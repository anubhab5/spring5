package com.springprac.jpa.hibernate.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springprac.jpa.hibernate.demo.entity.Course;
import com.springprac.jpa.hibernate.demo.entity.Review;

@Repository
@Transactional
public class CourseRepository {

	@Autowired
	EntityManager em;

	public Course findById(long id) {
		return em.find(Course.class, id);
	}

	public void deleteById(long id) {
		Course courseToDelete = findById(id);
		em.remove(courseToDelete);
	}

	public Course saveCourse(Course course) {
		if (course.getId() == 0L) {
			em.persist(course);
		} else {
			em.merge(course);
		}
		return course;
	}

	public List<Course> getCourseList() {
		return em.createNamedQuery("query_get_all_courses", Course.class).getResultList();
	}

	public void playAround() {
//		Course newCourse = findById(2l);
//		newCourse.setName("just testing my courses");

		Course c = new Course("test Course");
		em.persist(c);
	}
	
	public void addReviewsForCourse() {		
		Course course = findById(2l);
		System.out.println(course.getReviews());		
		Review review1 = new Review("4", "Very Gooood!");
		course.addReview(review1);
		review1.setCourse(course);		
		em.persist(review1);
	}
	
	public void addReviewsForCourseGeneralized(Long courseId, List<Review> reviews) {		
		Course course = findById(courseId);		
		for(Review review: reviews) {
			course.addReview(review);
			review.setCourse(course);
			em.persist(review);
		}		
	}
}
