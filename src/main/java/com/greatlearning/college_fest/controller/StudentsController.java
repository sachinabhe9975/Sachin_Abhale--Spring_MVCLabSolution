package com.greatlearning.college_fest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Component;
import com.greatlearning.college_fest.entity.Student;
import com.greatlearning.college_fest.service.StudentService;



@Controller
@RequestMapping("/students")
public class StudentsController {

	@Autowired /*spring managed */
	private StudentService studentService;
	
	@RequestMapping("/list")
	
	public String findAll(Model model)
	{
		List<Student> studentList=studentService.findAll() ;
		model.addAttribute("student", studentList);
		return "Students";
	}
	
	@RequestMapping("/save")
	public String save(@RequestParam("student_id") Integer student_id,@RequestParam("first_name") String first_name,@RequestParam("last_name") String last_name,
			@RequestParam("student_department") String student_department , @RequestParam("student_country") String student_country)
	{
		Student b=null;
		if(student_id!=-1)
		{
			b=studentService.findById(student_id);
			b.setFirst_name(first_name);
			b.setLast_name(last_name);
			b.setStudent_department(student_department);
			b.setStudent_country(student_country);
			
		}
		else
			b=new Student(first_name,last_name,student_department,student_country);
		
		studentService.save(b);
		return "redirect:list";
	}
	
	
	@RequestMapping("/addStudent")
	public String addStudent(@RequestParam("id") Integer id, Model model)
	{
	
		
		if(id!=-1)
		{
			Student b=studentService.findById(id);
			model.addAttribute("student", b);
		}
		else
		{
			Student b=new Student();
			b.setStudent_id(-1);
			model.addAttribute("student", b);
		}
		
		return "Registrationform";
	}
	
	
	@RequestMapping("/deleteStudent")
	public String delete(@RequestParam("id") Integer id)
	{
		Student b=null;
		if(id!=-1)
		{
			b=studentService.findById(id);
			studentService.delete(b);
		}
		
		return "redirect:list";
	}
	
	@RequestMapping("/search")
	public String findBydepartment(	@RequestParam("student_department")String student_department,Model model)
	{
		List<Student> studentList=studentService.findBydepartment( student_department) ;
		System.out.println(studentList);
		if(studentList.size()!=0)
			model.addAttribute("student", studentList);
		else
			model.addAttribute("error", "No Students  Found");
		return "Students";
	}


}
