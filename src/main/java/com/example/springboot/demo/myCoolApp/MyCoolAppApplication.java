package com.example.springboot.demo.myCoolApp;

import com.example.springboot.demo.myCoolApp.dao.StudentDAO;
import com.example.springboot.demo.myCoolApp.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class  MyCoolAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyCoolAppApplication.class, args);
	}

	// CommandLineRunner is from the spring boot framework.
	// Executed after the Spring Beans have been loaded
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDao){
		// lambda expression
		return runner ->{
			// createStudent(studentDao);
			// readStudent(studentDao);
			// queryForStudents(studentDao);
			// queryForStudentsByLastName(studentDao);
			// updateStudent(studentDao);
			// deleteStudent(studentDao);
			// deleteAll(studentDao);
		};
	}

	private void deleteAll(StudentDAO studentDao) {
		int rowsAmount = studentDao.deleteAll();
		System.out.println(rowsAmount + " was deleted");
	}

	private void deleteStudent(StudentDAO studentDao) {
		studentDao.deleteById(2);
	}

	private void updateStudent(StudentDAO studentDao) {
		Student student = studentDao.findById(3);
		student.setFirstName("Ahorro");
		student.setEmail("AhorroMaho@proton.com");
		studentDao.update(student);
	}

	private void queryForStudentsByLastName(StudentDAO studentDao) {
		List<Student> list = studentDao.findByLastName("Maho25");
		System.out.println(list);
	}

	private void queryForStudents(StudentDAO studentDao) {
		List<Student> students = studentDao.findAll();
		students.forEach(System.out::println);

	}

	private void readStudent(StudentDAO studentDao) {
		Student student = studentDao.findById(3);
		System.out.println(student);
	}

	private void createStudent(StudentDAO studentDao) {
		for(int i = 0; i < 5; i++){
			Student student = new Student("Aho" + i, "Maho" + i, i+"ahomaho@gmail.com");
			studentDao.save(student);
			System.out.println("Saved student. Generated id: " + student.getId());
		}
	}


}
