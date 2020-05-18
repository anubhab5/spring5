package com.springprac.jpa.hibernate.demo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.springprac.jpa.hibernate.demo.entity.Course;
import com.springprac.jpa.hibernate.demo.entity.Review;
import com.springprac.jpa.hibernate.demo.entity.Student;
import com.springprac.jpa.hibernate.demo.repository.CourseRepository;
import com.springprac.jpa.hibernate.demo.repository.StudentRepository;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Autowired
	StudentRepository studentRepo;
	
	@Autowired
	CourseRepository courseRepo;
	
	@Autowired
	EntityManager em;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	@Transactional
	public void run(String... args) throws Exception {
		
		List<Student> studentList = studentRepo.getStudentList();
//		System.out.println(studentList);
		
		Student stud = studentRepo.findById(6l);
		System.out.println(stud);
		System.out.println(stud.getCourse());
		
//		studentRepo.insertStudentAndCourseHarcCoded();		
		studentRepo.insertStudentAndCourse(new Student("Papa"), new Course("MicroServices mastering"));
		
		// Course someCourse = new Course("Test Course");
		// courseRepo.addReviewsForCourse();		
		
		// Add Reviews for a course
		/*
		List<Review> reviews= new ArrayList<Review>();
		reviews.add(new Review("2", "GGGG"));
		reviews.add(new Review("1", "Pathetic"));		
		courseRepo.addReviewsForCourseGeneralized(3l, reviews); 
		*/
		// Add Reviews for a course
		

//		Course c = cr.findById(3L);
//		System.out.println(cr.findById(2L));
//		cr.deleteById(2L);

//		Course newCourse = cr.findById(1l);
//		newCourse.setName("MySql Beginner To Advanced in 10 days");

//		cr.saveCourse(new Course(1l, "MYSql Beginner to Advanced1"));
//		System.out.println(cr.getCourseList());

//		List<Course> c = cr.getCourseList();
//		System.out.println(c);
		System.out.println("From the runner class");

//		sr.saveStudentWithPassport();
//		Student s = sr.findById(4l);
		
//		System.out.println(s);
//		System.out.println(s.getPassport());
	}

}
