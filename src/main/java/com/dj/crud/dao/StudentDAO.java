package com.dj.crud.dao;

import java.util.List;

import com.dj.crud.entity.Student;

public interface StudentDAO {

	void save(Student theStudent);
	
	Student findById(Integer id);
	
	List<Student> findAll();
	
	List<Student> findByLastName(String lastName);
	
	void update(Student student);
	
	void delete(Integer id);
}
