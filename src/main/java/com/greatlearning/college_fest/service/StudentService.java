package com.greatlearning.college_fest.service;

import java.util.List;

import com.greatlearning.college_fest.entity.Student;

public interface StudentService {

		
		public List<Student> findAll();
		public void save(Student b);
		public Student findById(Integer id);
		public void delete(Student b);
		public List<Student> findBydepartment( String student_department);
		
	}


