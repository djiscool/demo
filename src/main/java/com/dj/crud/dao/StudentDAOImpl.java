package com.dj.crud.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dj.crud.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class StudentDAOImpl implements StudentDAO {
	
	
	private EntityManager entityManager;
		
	@Autowired
	public StudentDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	@Transactional
	public void save(Student theStudent) {
		entityManager.persist(theStudent);
		
	}

	@Override
	public Student findById(Integer id) {
		return entityManager.find(Student.class, id);
	}

	@Override
	public List<Student> findAll() {
		
		TypedQuery<Student> theQuery = entityManager.createQuery("From Student order by lastName", Student.class);
		
		return theQuery.getResultList();
	}

	@Override
	public List<Student> findByLastName(String lastName) {
		TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student WHERE lastName=:theData", Student.class);
		
		theQuery.setParameter("theData", lastName);
		
		return theQuery.getResultList();
	}

	@Override
	@Transactional
	public void update(Student student) {
		entityManager.merge(student);
		
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		Student student = entityManager.find(Student.class, id);
		entityManager.remove(student);
		
	}
	
	

}
