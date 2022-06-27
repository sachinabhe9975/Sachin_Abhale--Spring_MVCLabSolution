package com.greatlearning.college_fest.service;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.greatlearning.college_fest.entity.Student;


@Repository
public class StudentServiceImpl implements StudentService {
	
    private SessionFactory sessionfactory;
	
	private Session session;
	
	
	public StudentServiceImpl(SessionFactory sessionfactory) {
		this.sessionfactory = sessionfactory;		
		try {
			session=this.sessionfactory.getCurrentSession();
			
		} catch (HibernateException e) {
			session=this.sessionfactory.openSession();
		}
	}


	
	@Transactional
	public List<Student> findAll()
	{
		List<Student> studentList=session.createQuery(" from Student").list();
		/*for(Student b:studentList)
		{
			System.out.println(b);
		}
		*/
		return studentList;
	}
	
	@Transactional
	public Student findById(Integer id)
	{
		Student student=session.get(Student.class, id);		
		return student;
	}
	
	@Transactional
	public void save(Student student)
	{
		Transaction tr=session.beginTransaction();
		session.saveOrUpdate(student);
		tr.commit();
	}

	@Transactional
	public void delete(Student b) {
		Transaction tr=session.beginTransaction();
		session.delete(b);
		tr.commit();
	}



	@Override
	@Transactional
	public  List<Student> findBydepartment( String student_department) {
		List<Student> studentList=null;
		String query="";
		
			query="from Student where student_department like '%"+student_department+"%'";
		if(query.length()!=0)
		{
			studentList=session.createQuery(query).list();
		}
		return studentList;
	}


	


	


}
