package com.run;
import java.sql.*;

public class DataBase {
	
	 String jdbc_driver="com.mysql.jdbc.Driver";
	 String db_url="jdbc:mysql://localhost:3306/college";
	 String uname="root";
	 String password="password";
         Connection conn=null;
	 Statement stmt=null;
	 ResultSet rs=null;
	 public DataBase() {}
	 public Statement getConnection() {
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(db_url,uname,password);
			stmt=conn.createStatement();
			return stmt;
		}
		catch(Exception e) {System.out.println(e.getMessage());}
		return null;
	}
	
	public  boolean login(String uname,String password) {
		try {
		String sql="select * from student";
		rs=stmt.executeQuery(sql);
		while(rs.next()) {
			
			String u=rs.getString(1);
			String p=rs.getString(2);
			
			if(uname.equals(u) && password.equals(p))
				return true;
		}}
		catch(Exception e) {System.out.println(e.getMessage());}
		return false;
	}
	public  boolean insertStudent(String uname,String password,String cname,String dept){
		try {
		String sql="insert into student values('"+uname+"','"+password+"','"+cname+"','"+dept+"')";
		stmt.executeUpdate(sql);
		return true;
		}
		catch(Exception e) {System.out.println(e.getMessage());}
		return false;
	}
	
	public void printStudent(){
	 
	   try {
	   String sql="select * from student";
	   rs=stmt.executeQuery(sql);
	   while(rs.next()) {
		   
		String uname=rs.getString(1);
		String password=rs.getString(2);
		String cname=rs.getString(3);
		String dept=rs.getString(4);
		
		System.out.println(uname+" "+password+" "+cname+"  "+dept);
		}}
	   catch(Exception e) {System.out.println(e.getMessage());}
	}
	  public static void main(String args[]) throws SQLException { 
      DataBase db=new DataBase();
      db.getConnection();
	  System.out.println(db.insertStudent("e","r","mca","nitt"));
	  
	  }
	 
}
