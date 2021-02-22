package jpa.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import jpa.dao.CourseDAO;
import jpa.entitymodels.Course;

public class CourseService implements CourseDAO {

	@Override
	public List<Course> getAllCourses() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("SMSBoston");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		Query selectAllCourse = entityManager.createQuery("SELECT c FROM Course c");
		List<Course> courseList = selectAllCourse.getResultList();
		
		entityManager.close();
		entityManagerFactory.close();
		return courseList;
	}

}
