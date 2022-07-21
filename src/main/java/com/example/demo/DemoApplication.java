package com.example.demo;

import com.example.demo.repository.StudentRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.example.demo.Entity.*;
import org.springframework.context.annotation.ComponentScan;

import java.sql.*;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(DemoApplication.class, args);
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "thangthang1!");
		String query = "SELECT * FROM bangchamcong;";
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(query);
		while (rs.next()) {
			int id = rs.getInt("id");
			int id_nv = rs.getInt("id_nv");
			int id_pb = rs.getInt("id_pb");
			Time gioden = rs.getTime("gioden");
			Time giove = rs.getTime("giove");
			Date ngay = rs.getDate("ngay");
			// print the results
			System.out.format("%s | %s | %s | %s | %s | %s\n", id, id_nv, id_pb, gioden, giove, ngay);
		}
		st.close();
	}
}

		// Annotation based spring context
//		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
//		context.scan("com.example.demo");
//		context.refresh();
//
//		// Getting the Bean from the component class
//		ComponentDemo componentDemo
//				= context.getBean(ComponentDemo.class);
//		componentDemo.demoFunction();
//
//		ServiceDemo serviceDemo = context.getBean(ServiceDemo.class);
//		int i = serviceDemo.factorial(5);
//		System.out.println("Service demo (fatorial of 5): " + i);
//
//		StudentRepository studentRepository = context.getBean(StudentRepository.class);
//		Student s;
//		studentRepository.save(new Student(1L, "pdt", 20));
//		s=studentRepository.findStudentById(1L);
//		System.out.println(s);
//
//		// Closing the context
//		// using close() method
//		context.close();
		//next commit
//		try {
//			Connection connection = DriverManager.getConnection("");
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
