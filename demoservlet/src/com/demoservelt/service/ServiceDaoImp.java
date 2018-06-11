package com.demoservelt.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.demoservelt.model.User;
import com.demoservlet.db.Dbconn;

public class ServiceDaoImp implements ServiceDao{
	
 static Connection conn=null;
 public  boolean checkLogin(String uname,String password)
 {
	 boolean responce=false;
	 try {
		 conn=Dbconn.getSqlConnection();
		 Statement stmt=conn.createStatement();			
		 ResultSet rs=stmt.executeQuery("select * from regacc where uname='"+uname+"'and password='"+password+"' ");        	
			if(rs.first()){
				responce=true;
			 //return true;
			}
		conn.close();	
		 
			
	} catch (Exception e) {
	System.out.println(e);
	}
	 return responce;
 }
@Override
public List<User> findAll() {
	List<User> users=new ArrayList<User>();
	User user=null;
	try {
		conn=Dbconn.getSqlConnection();
		 Statement stmt=conn.createStatement();			
		 ResultSet rs=stmt.executeQuery("select * from regacc  where status=1");   
		 while(rs.next())
		 {
			user=User.getUser();
			user.setFname(rs.getString("fname"));
			user.setLname(rs.getString("lname"));
			user.setUname(rs.getString("uname"));
			user.setMail(rs.getString("mail"));
			user.setPassword(rs.getString("password"));
		
			users.add(user);
			//System.out.println(user);
			 
		 }

	} catch (Exception e) {
   System.out.println(e);		// TODO: handle exception
	}
	
	
	return users;
}
 
	
public void addDiv()
{
	
	
	
	
	
}






}
