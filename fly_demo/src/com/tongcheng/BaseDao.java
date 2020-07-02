package com.tongcheng;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class BaseDao {
//声明属性
	static Connection conn;//链接对象
	static PreparedStatement psts;
	static ResultSet rs;
	static int count;//影响行数
	
	//1，得到一个链接对象的方法
	public static Connection getConn(){
		//加载驱动
		try{
			Class.forName("com.mysql.jdbc.Driver");
			//获得链接对象
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8","root","");
		   return conn;
		}catch (ClassNotFoundException e){e.printStackTrace();
		}catch (SQLException e){e.printStackTrace();
		}
		return null;
	}
	
	//获得结果集对象的方法
	public static ResultSet executeQuery(String sql,Object[] args){
		getConn();
		try{
			psts=conn.prepareStatement(sql);
			for(int i=0;i<args.length;i++){
				psts.setObject(i+1,args[i]);
			}
			//执行查询方法
			rs=psts.executeQuery();
			return rs;
		} catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}
	
	//增删改都有executeUpadate方法
	public static int executeUpdate(String sql,Object[] args){
		getConn();
		try{
			psts=conn.prepareStatement(sql);
			for(int i=0;i<args.length;i++){
				psts.setObject(i+1, args[i]);
			}
			//执行update方法
			count=psts.executeUpdate();
			return count;
		}catch(SQLException e){
			e.printStackTrace();
		}
		return 0;
	}
	
	//关闭资源的方法
	public static void closeResource(){
		if(rs!=null){
			try{
				rs.close();
				if(psts!=null){
					psts.close();
					}
				if(conn!=null){
					conn.close();
					}
				}catch(SQLException e){
					e.printStackTrace();
				}
		}
	}
}
