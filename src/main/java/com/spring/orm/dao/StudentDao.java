package com.spring.orm.dao;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.spring.orm.entities.Student;

public class StudentDao {
	private HibernateTemplate hibernateTemplate;
	
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}


	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Transactional
	public int insert(Student student) {
		Integer i=(Integer) this.hibernateTemplate.save(student);
		return i;
	}
	
	//get the single data(object)
	
	public Student getStudent(Integer studentId) {
		Student student=this.hibernateTemplate.get(Student.class, studentId);
		return student;
		
	}
	
	public List<Student> getallStudents(){
		List<Student> students=this.hibernateTemplate.loadAll(Student.class);
		return students;
		
	}
//	delete data
	@Transactional
	public void deleteStudent(Integer studentId) {
		Student student=this.hibernateTemplate.get(Student.class, studentId);
		this.hibernateTemplate.delete(student);
	}
	
	
	
	//update data
	@Transactional
	public void updateStudent(Student student) {
//		this.hibernateTemplate.get(null, studentId)
		//Student student=this.hibernateTemplate.get(Student.class, studentId);
		this.hibernateTemplate.update(student);
	}

}
