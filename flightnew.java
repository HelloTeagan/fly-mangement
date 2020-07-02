package com.tongcheng;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.util.Scanner;

public class Flight extends BaseDao{
static Scanner input=new Scanner(System.in);
//查询所有航班
	public static void showFlys() throws Exception{
	String sql="select * from flight";
	Object[] args={};
	executeQuery{sql,args};
	System.out.println("编号\t"+"航班号\t"+"目的地\t"+"飞行时间\t");
	while(rs.next()){
		int id=rs.getInt(1);
		String fly_num=rs.getString(2);
		String des=rs.getString(3);
		Date fly_time=rs.getDate(4);
		
		 
		System.out.println(id+"\t"+fly_num+"\t"+des+"\t"+fly_time+"\t");
	}
	//关闭资源
	closeResource();
	}
	
	//按目的地查询航班
	public static void findFlightByDes(String des) throws Exception{
	String sql="select * from flight where des like ?";
	Object[] args={des};
	executeQuery{sql,args};
	System.out.println("编号\t"+"航班号\t"+"目的地\t"+"飞行时间\t");
	while(rs.next()){
		int id=rs.getInt(1);
		String fly_num=rs.getString(2);
		String des1=rs.getString(3);
		Date fly_time=rs.getDate(4);
		
		 
		System.out.println(id+"\t"+fly_num+"\t"+des1+"\t"+fly_time+"\t");
	}
	//关闭资源
	closeResource();
	}
	
	//根据时间查找
	public static void findFlightByT(String time) throws Exception{
	String sql="select * from flight where fly_time=?";
	Object[] args={des};
	executeQuery{sql,args};
	System.out.println("编号\t"+"航班号\t"+"目的地\t"+"飞行时间\t");
	while(rs.next()){
		int id=rs.getInt(1);
		String fly_num=rs.getString(2);
		String des1=rs.getString(3);
		Date fly_time=rs.getDate(4);
		
		 
		System.out.println(id+"\t"+fly_num+"\t"+des1+"\t"+fly_time+"\t");
	}
	//关闭资源
	closeResource();
	}
	
	//增加航班的操作
	public static void addFly() throws Exception{
		System.out.println("请输入编号");
		String id=input.next();
		System.out.println("请输入航班号");
		String flynum=input.next();
		System.out.println("请输入目的地");
		String des=input.next();
		System.out.println("请输入飞行时间");
		String time=input.next();
	
	String sql="insert into flight(id,fly_num,des,fly_time)value(?,?,?,?)";
	Object[] args={fly_num,des,time};
	executeQuery{sql,args};
	count=psts.executeUpdate();
	if(count>0){
		System.out.println("增加成功");
	}
	else{
		System.out.println("增加失败");
	}
	//
	closeResource();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
try{
	//showFlys();
	//String des="%京%";
	//findFlightByDes(des);
	//String time="2019-09-11"
	addFly();
}catch(Exception e){
	e.printStackTrace();
}
	}

}
