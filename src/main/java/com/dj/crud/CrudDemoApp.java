package com.dj.crud;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.dj.crud.dao.StudentDAO;
import com.dj.crud.entity.Student;

@SpringBootApplication
public class CrudDemoApp {

	public static void main(String[] args) {
		SpringApplication.run(CrudDemoApp.class, args);

	}
	
	@Bean
	public CommandLineRunner commandLineRuner(StudentDAO sdaol) {
		return runner -> {
			deleteStudent(sdaol);
			System.exit(0);
		};
	}

	private void deleteStudent(StudentDAO sdaol) {
		sdaol.delete(1);
				
	}

	private void updateStudent(StudentDAO sdaol) {
		int studentId = 1;
		System.out.println("Getting student with id: " + studentId);
		
		Student myStudent = sdaol.findById(studentId);
		
		System.out.println("Updating student..");
		
		myStudent.setFirstName("Scooby");
		sdaol.update(myStudent);
		
		System.out.println("Updated student: " + myStudent);
		
	}

	private void queryForStudents(StudentDAO sdaol) {
		List<Student> students = sdaol.findAll();
		
		for (Student student : students) {
			System.out.println(student);
		}
		
	}

	private void createStudent(StudentDAO sdaol) {

		System.out.println("Creating new student object...");
		
		Student tempStudent = new Student("Paul", "Dode","anemail2@mail.com");
		
		System.out.println("Saving the student...");
		sdaol.save(tempStudent);;
		
		System.out.println("Saved student. Genereated id: " + tempStudent.getId());
	}
	
	private void readStudent(StudentDAO sdaol) {
		System.out.println("Creating new student object");
		Student tempStudent = new Student("Daffy", "Duck","daffyemail@mail.com");
		
		System.out.println("Saving the student");
		sdaol.save(tempStudent);
		
		int theId = tempStudent.getId();
		System.out.println("Saved student. Generated id: " + theId);
		
		Student myStudent = sdaol.findById(theId);
		System.out.println("Found the student: " + myStudent);
		
	}
	
	private void queryForStudentsByLastName(StudentDAO sdaol) {
		List<Student> students = sdaol.findByLastName("Doe");
		
		for (Student student : students) {
			System.out.println(student);
		}
		
	}

}
