package com.example.demo;

import com.example.demo.repository.StudentRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.example.demo.Entity.*;
import org.springframework.context.annotation.ComponentScan;

import java.sql.*;

@ComponentScan("com.example.demo.repository")
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		// Annotation based spring context
		AnnotationConfigApplicationContext context
				= new AnnotationConfigApplicationContext();
		context.scan("com.example.demo");
		context.refresh();

		// Getting the Bean from the component class
		ComponentDemo componentDemo
				= context.getBean(ComponentDemo.class);
		componentDemo.demoFunction();

		ServiceDemo serviceDemo = context.getBean(ServiceDemo.class);
		int i = serviceDemo.factorial(5);
		System.out.println("Service demo (fatorial of 5): " + i);

		StudentRepository studentRepository = context.getBean(StudentRepository.class);
		Student s;
		studentRepository.save(new Student(1L, "pdt", 20));
		s=studentRepository.findStudentById(1L);
		System.out.println(s);

		// Closing the context
		// using close() method
		context.close();
		//next commit
	}

}
