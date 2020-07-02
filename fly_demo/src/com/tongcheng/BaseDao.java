package com.tongcheng;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class BaseDao {
//��������
	static Connection conn;//���Ӷ���
	static PreparedStatement psts;
	static ResultSet rs;
	static int count;//Ӱ������
	
	//1���õ�һ�����Ӷ���ķ���
	public static Connection getConn(){
		//��������
		try{
			Class.forName("com.mysql.jdbc.Driver");
			//������Ӷ���
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8","root","");
		   return conn;
		}catch (ClassNotFoundException e){e.printStackTrace();
		}catch (SQLException e){e.printStackTrace();
		}
		return null;
	}
	
	//��ý��������ķ���
	public static ResultSet executeQuery(String sql,Object[] args){
		getConn();
		try{
			psts=conn.prepareStatement(sql);
			for(int i=0;i<args.length;i++){
				psts.setObject(i+1,args[i]);
			}
			//ִ�в�ѯ����
			rs=psts.executeQuery();
			return rs;
		} catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}
	
	//��ɾ�Ķ���executeUpadate����
	public static int executeUpdate(String sql,Object[] args){
		getConn();
		try{
			psts=conn.prepareStatement(sql);
			for(int i=0;i<args.length;i++){
				psts.setObject(i+1, args[i]);
			}
			//ִ��update����
			count=psts.executeUpdate();
			return count;
		}catch(SQLException e){
			e.printStackTrace();
		}
		return 0;
	}
	
	//�ر���Դ�ķ���
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
