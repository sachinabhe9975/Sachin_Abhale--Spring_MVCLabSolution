package com.greatlearning.college_fest.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="student")
public class Student {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int student_id;
	
	
	private String first_name;
	
	
	private String last_name;
	

	private String student_department;
	
	private String student_country;

	

	public Student(String first_name, String last_name, String student_department, String student_country) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.student_department = student_department;
		this.student_country = student_country;
	}

	public Student() {
		// TODO Auto-generated constructor stub
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getStudent_department() {
		return student_department;
	}

	public void setStudent_department(String student_department) {
		this.student_department = student_department;
	}

	public String getStudent_country() {
		return student_country;
	}

	public void setStudent_country(String student_country) {
		this.student_country = student_country;
	}

	@Override
	public String toString() {
		
	return ("Students Details: \nFirst Name: "+first_name+"\nLast Name: "
	+last_name+"\nStudent department: "+student_department+"Student Country "+student_country);
	}

	public int getStudent_id() {
		return student_id;
	}

	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	

	
	}

	
	
	
	
}

