package com.sankar.demorest;
import java.util.*;
import java.sql.*;
public class StudentRepository {
   
	Connection con =null;
	
	public StudentRepository()
	{
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			 con=DriverManager.getConnection("jdbc:mysql://localhost/student","root","");   
		}
		 catch(Exception e)
		 { 
			 System.out.println(e);
		 } 
		
	}
	
	
	public List<Student> getStudents()
	{
		List<Student> students = new ArrayList<>();
		try {
		Statement stmt=con.createStatement();  
		ResultSet rs=stmt.executeQuery("select * from users");  
		while(rs.next())  
		{
			Student s1 = new Student();
			s1.setStudentid(rs.getInt(1));
			s1.setName(rs.getString(2));
			
			students.add(s1);
		}
		con.close();  
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
		return students;
	}
	
	public Student getStudent(int id)
	{
		Student s1 = new Student();
		try {
		Statement stmt=con.createStatement();  
		ResultSet rs=stmt.executeQuery("select * from users where id="+id);  
		if(rs.next())  
		{
			
			s1.setStudentid(rs.getInt(1));
			s1.setName(rs.getString(2));
			
			
		}
		con.close();  
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
		return s1;
	}


	public void create(Student s1) {
		try {
			PreparedStatement stmt=con.prepareStatement("insert into users values(?, ?)"); 
			stmt.setInt(1,s1.getStudentid());
			stmt.setString(2, s1.getName());
			stmt.executeUpdate();
			
			con.close();  
			}
			catch (Exception e) {
				System.out.println(e);
			}
		
	}
	
	
}
