package com.sankar.demorest;

public class Student {
 
	private int studentid;
	private String name;
	
	public void setStudentid(int studentid) {
		this.studentid = studentid;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Student [studentid=" + studentid + ", name=" + name + "]";
	}
	
	public int getStudentid() {
		return studentid;
	}
	public String getName() {
		return name;
	}
	
	
}
