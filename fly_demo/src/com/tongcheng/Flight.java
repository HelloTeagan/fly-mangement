package com.tongcheng;

import java.util.Date;
import java.util.Scanner;

public class Flight extends BaseDao{
	
static Scanner input=new Scanner(System.in);

//查询所有航班
	public static void showFlys() throws Exception{
	String sql="select * from flight";
	Object[] args={};
	executeQuery(sql, args);
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
	executeQuery(sql,args);
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
	Object[] args={time};
	executeQuery(sql,args);
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
	Object[] args={id,flynum,des,time};
	executeQuery(sql,args);
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
	
	//删除方法
	public static void delete() throws Exception{
		System.out.println("请输入要删除的航班编号");
		int id=input.nextInt();
	    String ids=String.valueOf(id);
	String sql="delete from flight where id=?";
	Object[] args={ids};
	executeQuery(sql,args);
	count=psts.executeUpdate();
	if(count>0){
		System.out.println("删除成功");
	}
	else{
		System.out.println("删除失败");
	}
	//关闭资源
	closeResource();
	}
	
	//更新操作
	public static void update() throws Exception{
		System.out.println("请输入要更新的航班编号");
		int id=input.nextInt();
		System.out.println("请输入要更改的航班号");
		String flynum=input.next();
		System.out.println("请输入飞行时间");
		String time=input.next();
	String ids=String.valueOf(id);
	String sql="update flight set fly_num=?,fly_time=? where id=?";
	Object[] args={flynum,time,ids};
	executeQuery(sql,args);
	count=psts.executeUpdate();
	if(count>0){
		System.out.println("更新成功");
	}
	else{
		System.out.println("更新失败");
	}
	//关闭资源
	closeResource();
	}
	
	public static void main(String[] args) {
		
		System.out.println("**********欢迎使用航班信息管理系统***********");
		System.out.println("请选择操作：1.列出所有航班，2.按起飞时间查询，3.按目的地查询，4.删除航班，5.更新航班，6.离开系统");

		int i=input.nextInt();
	try{
		switch(i){
		case 1:showFlys();break;
		case 2:String time="2019-09-11";findFlightByT(time);break;
		case 3:String des="%京%";findFlightByDes(des);break;
		case 4:delete();break;
		case 5:update();break;
		case 6:addFly();
		default:System.out.println("input error!!");
		}

	
}catch(Exception e){
	e.printStackTrace();
}
	}

}
