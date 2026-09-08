package com.primulExercitiu.demo;

import com.primulExercitiu.demo.dao.StudentDAO;
import com.primulExercitiu.demo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			//createStudent(studentDAO);
			//createMultipleStudents(studentDAO);
			//readStudent(studentDAO);
			//queryForStudents(studentDAO);
			//queryForStudentsByLastName(studentDAO);
			//updateStudent(studentDAO);
			//deleteStudent(studentDAO);
			deleteAllStudents(studentDAO);
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

	private void createMultipleStudents(StudentDAO studentDAO) {
		System.out.println("Creating 3 student objects ...");
		Student newStudent1 = new Student("Andrei", "Munteanu", "andrei@pixelacademy.md");
		Student newStudent2 = new Student("Iulian", "Vataman", "iulic@pixelacademy.md");
		Student newStudent3 = new Student("Maria", "Mirabela", "mira@pixelacademy.md");

		//salvam obiectele student in baza de date
		System.out.println("Saving the students ...");
		studentDAO.save(newStudent1);
		studentDAO.save(newStudent2);
		studentDAO.save(newStudent3);

	}

	private void readStudent(StudentDAO studentDAO) {

		//creeaza un obiect de tip Student
		System.out.println("Createing new student object ...");
		Student newStudent = new Student("Mircea", "Popescu", "mirceap@pixel.academy");

		//salveaza studetul in baza  de date
		System.out.println("Saving the student ...");
		studentDAO.save(newStudent);

		//afiseaza id-ul studetului salvat
		int theId = newStudent.getId();
		System.out.println("Saved student. Generated id: " + theId);

		//recuperaza studetul pe ba ID-ului {PK}
		System.out.println("Retrieving student with id: " + theId);
		Student myStudent = studentDAO.findById(theId);

		//afiseaza detalliile studetului
		System.out.println("Found the student: " + myStudent);
	}

	private void queryForStudents(StudentDAO studentDAO) {
		//obtine lista de studenti
		List<Student> theStudent = studentDAO.findAll();

		//afiseaza lista de studenti
		for (Student newStudent : theStudent) {
			System.out.println(newStudent);
		}
	}
	private void queryForStudentsByLastName(StudentDAO studentDAO) {

		//returneaza lista de studenti
		List<Student> theStudent = studentDAO.findByLastName("Popescu");

		//ataseaza lista de studenti
		for(Student newStudent : theStudent) {
			System.out.println(newStudent);
		}
	}
	private void updateStudent (StudentDAO studentDAO) {
		//gaseste studentul in baza de date folosind ID (Cheia primara)
		int studentId = 3;
		System.out.println("Getting student with id: " + studentId);
		Student newStudent = studentDAO.findById(studentId);

		//modifica prenumele studentului in "Ion"
		System.out.println("Updating student ...");
		newStudent.setFirstName("Doina");

		//salveaza modificarile in baza de date
		studentDAO.update(newStudent);

		//afiseaza detaliile studentului actualizat
		System.out.println("Update student: " + newStudent);

	}
	private void deleteStudent(StudentDAO studentDAO) {

		int studentId = 5;
		System.out.println("Deleting student id: " + studentId);
		studentDAO.delete(studentId);
	}
	private void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println("Deleting all students.");
		int numRowsDeleted = studentDAO.deleteAll();
		System.out.println("Deleted row count: " + numRowsDeleted);
	}

}
