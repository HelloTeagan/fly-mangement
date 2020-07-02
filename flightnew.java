package com.tongcheng;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.util.Scanner;

public class Flight extends BaseDao{
static Scanner input=new Scanner(System.in);
//��ѯ���к���
	public static void showFlys() throws Exception{
	String sql="select * from flight";
	Object[] args={};
	executeQuery{sql,args};
	System.out.println("���\t"+"�����\t"+"Ŀ�ĵ�\t"+"����ʱ��\t");
	while(rs.next()){
		int id=rs.getInt(1);
		String fly_num=rs.getString(2);
		String des=rs.getString(3);
		Date fly_time=rs.getDate(4);
		
		 
		System.out.println(id+"\t"+fly_num+"\t"+des+"\t"+fly_time+"\t");
	}
	//�ر���Դ
	closeResource();
	}
	
	//��Ŀ�ĵز�ѯ����
	public static void findFlightByDes(String des) throws Exception{
	String sql="select * from flight where des like ?";
	Object[] args={des};
	executeQuery{sql,args};
	System.out.println("���\t"+"�����\t"+"Ŀ�ĵ�\t"+"����ʱ��\t");
	while(rs.next()){
		int id=rs.getInt(1);
		String fly_num=rs.getString(2);
		String des1=rs.getString(3);
		Date fly_time=rs.getDate(4);
		
		 
		System.out.println(id+"\t"+fly_num+"\t"+des1+"\t"+fly_time+"\t");
	}
	//�ر���Դ
	closeResource();
	}
	
	//����ʱ�����
	public static void findFlightByT(String time) throws Exception{
	String sql="select * from flight where fly_time=?";
	Object[] args={des};
	executeQuery{sql,args};
	System.out.println("���\t"+"�����\t"+"Ŀ�ĵ�\t"+"����ʱ��\t");
	while(rs.next()){
		int id=rs.getInt(1);
		String fly_num=rs.getString(2);
		String des1=rs.getString(3);
		Date fly_time=rs.getDate(4);
		
		 
		System.out.println(id+"\t"+fly_num+"\t"+des1+"\t"+fly_time+"\t");
	}
	//�ر���Դ
	closeResource();
	}
	
	//���Ӻ���Ĳ���
	public static void addFly() throws Exception{
		System.out.println("��������");
		String id=input.next();
		System.out.println("�����뺽���");
		String flynum=input.next();
		System.out.println("������Ŀ�ĵ�");
		String des=input.next();
		System.out.println("���������ʱ��");
		String time=input.next();
	
	String sql="insert into flight(id,fly_num,des,fly_time)value(?,?,?,?)";
	Object[] args={fly_num,des,time};
	executeQuery{sql,args};
	count=psts.executeUpdate();
	if(count>0){
		System.out.println("���ӳɹ�");
	}
	else{
		System.out.println("����ʧ��");
	}
	//
	closeResource();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
try{
	//showFlys();
	//String des="%��%";
	//findFlightByDes(des);
	//String time="2019-09-11"
	addFly();
}catch(Exception e){
	e.printStackTrace();
}
	}

}
