package com.springprac.jpa.hibernate.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springprac.jpa.hibernate.demo.entity.Course;
import com.springprac.jpa.hibernate.demo.entity.Passport;
import com.springprac.jpa.hibernate.demo.entity.Student;

@Repository
@Transactional
public class StudentRepository {

	@Autowired
	EntityManager em;

	public Student findById(long id) {
		return em.find(Student.class, id);
	}

	public void deleteById(long id) {
		Student studentToDelete = findById(id);
		em.remove(studentToDelete);
	}

	public Student saveStudent(Student student) {
		if (student.getId() == 0L) {
			em.persist(student);
		} else {
			em.merge(student);
		}
		return student;
	}

	public List<Student> getStudentList() {
		return em.createNamedQuery("query_get_all_students", Student.class).getResultList();
	}

	public void playAround() {
		Student newStudent = findById(2l);
		newStudent.setName("just testing my students");
	}

	public void saveStudentWithPassport() {
		Passport p = new Passport("Z232147");
		em.persist(p);
		
		Student stud = new Student("Dan");
		stud.setPassport(p);
		em.persist(stud);
	}
	
	public void insertStudentAndCourseHarcCoded() {
		
		Student stud = new Student("Jack");
		Course course = new Course("angu learn");
		
		stud.addCourse(course);
		course.addStudent(stud);
		
		em.persist(stud);
		em.persist(course);
	}
	
	public void insertStudentAndCourse(Student student, Course course) {
		
		student.addCourse(course);
		course.addStudent(student);
		
		em.persist(student);
		em.persist(course);
	}
	
	
}
