package com.primulExercitiu.demo;

import com.primulExercitiu.demo.dao.StudentDAO;
import com.primulExercitiu.demo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			createStudent(studentDAO);
		};

	}

	private void createStudent(StudentDAO studentDAO) {

		//cream un obiect Student
		System.out.println("Creating new student object ...");
		Student newStudent = new Student("John","Doe", "john@pixelacademy.md");

		//salvam obiectul Student in baza de date folosind DAO
		System.out.println("Saving the student ...");
		studentDAO.save(newStudent);

		//afisam ID-ul studentului salvat
		System.out.println("Saved student. Generated id:" + newStudent.getId());

	}

}
