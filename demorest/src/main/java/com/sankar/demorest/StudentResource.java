package com.sankar.demorest;

import java.util.List;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("students")
public class StudentResource {
	
	
	StudentRepository repo = new StudentRepository();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Student> getStudents()
	{
		
		
		return repo.getStudents();
	}
	
	@GET
	@Path("student/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Student getStudent(@PathParam("id") int id)
	{
		
		
		return repo.getStudent(id);
	}
	
	@POST
	@Path("student")
	public Student createStudent(Student s1)
	{
		repo.create(s1);
		
		return s1;
	}
	
	
}
