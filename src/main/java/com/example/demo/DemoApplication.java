package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.*;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(DemoApplication.class, args);
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/newmodel", "root", "thangthang1!");
		String query = "select id_nv, nv.phongban_id, hoten, tenphong, count(if(gioden != cast('0:00' as time), 1, Null)) chamcong from bangchamcong\n" +
				"inner join nhanvien nv on nv.id = bangchamcong.id_nv\n" +
				"inner join phongban pb on pb.id = nv.phongban_id\n" +
				"group by id_nv";
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(query);
		while (rs.next()) {
			int id_nv = rs.getInt("id_nv");
			int phongban_id = rs.getInt("phongban_id");
			String hoten = rs.getString("hoten");
			String tenphong = rs.getString("tenphong");
			int chamcong = rs.getInt("chamcong");
			System.out.format("| %s | %s | %s | %s | %s |\n", id_nv, phongban_id, hoten, tenphong, chamcong);
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
