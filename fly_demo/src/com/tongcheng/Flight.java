package com.tongcheng;

import java.util.Date;
import java.util.Scanner;

public class Flight extends BaseDao{
	
static Scanner input=new Scanner(System.in);

//��ѯ���к���
	public static void showFlys() throws Exception{
	String sql="select * from flight";
	Object[] args={};
	executeQuery(sql, args);
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
	executeQuery(sql,args);
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
	Object[] args={time};
	executeQuery(sql,args);
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
	Object[] args={id,flynum,des,time};
	executeQuery(sql,args);
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
	
	//ɾ������
	public static void delete() throws Exception{
		System.out.println("������Ҫɾ���ĺ�����");
		int id=input.nextInt();
	    String ids=String.valueOf(id);
	String sql="delete from flight where id=?";
	Object[] args={ids};
	executeQuery(sql,args);
	count=psts.executeUpdate();
	if(count>0){
		System.out.println("ɾ���ɹ�");
	}
	else{
		System.out.println("ɾ��ʧ��");
	}
	//�ر���Դ
	closeResource();
	}
	
	//���²���
	public static void update() throws Exception{
		System.out.println("������Ҫ���µĺ�����");
		int id=input.nextInt();
		System.out.println("������Ҫ���ĵĺ����");
		String flynum=input.next();
		System.out.println("���������ʱ��");
		String time=input.next();
	String ids=String.valueOf(id);
	String sql="update flight set fly_num=?,fly_time=? where id=?";
	Object[] args={flynum,time,ids};
	executeQuery(sql,args);
	count=psts.executeUpdate();
	if(count>0){
		System.out.println("���³ɹ�");
	}
	else{
		System.out.println("����ʧ��");
	}
	//�ر���Դ
	closeResource();
	}
	
	public static void main(String[] args) {
		
		System.out.println("**********��ӭʹ�ú�����Ϣ����ϵͳ***********");
		System.out.println("��ѡ�������1.�г����к��࣬2.�����ʱ���ѯ��3.��Ŀ�ĵز�ѯ��4.ɾ�����࣬5.���º��࣬6.�뿪ϵͳ");

		int i=input.nextInt();
	try{
		switch(i){
		case 1:showFlys();break;
		case 2:String time="2019-09-11";findFlightByT(time);break;
		case 3:String des="%��%";findFlightByDes(des);break;
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
