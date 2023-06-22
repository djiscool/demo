package com.dj.crud;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrudDemoApp {

	public static void main(String[] args) {
		SpringApplication.run(CrudDemoApp.class, args);

	}
	
	@Bean
	public CommandLineRunner commandLineRuner(String[] args) {
		return runner -> {
			System.out.println("Hello World");
		};
	}

}
