package com.dj.crud;

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
			createStudent(sdaol);
		};
	}

	private void createStudent(StudentDAO sdaol) {

		System.out.println("Creating new student object...");
		
		Student tempStudent = new Student("Paul", "Doe","anemail@mail.com");
		
		System.out.println("Saving the student...");
		sdaol.save(tempStudent);;
		
		System.out.println("Saved student. Genereated id: " + tempStudent.getId());
	}

}
