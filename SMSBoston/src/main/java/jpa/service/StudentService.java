package jpa.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import jpa.dao.StudentDAO;
import jpa.entitymodels.Course;
import jpa.entitymodels.Student;

public class StudentService implements StudentDAO {

	List<Course> cList = new ArrayList<Course>();

	@Override
	public List<Student> getAllStudents() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("SMSBoston");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		Query selectAllStd = entityManager.createQuery("SELECT s FROM Student s");
		List<Student> stdList = selectAllStd.getResultList();
		
		return stdList;
	}

	@Override
	public Student getStudentByEmail(String sEmail) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("SMSBoston");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Student student = new Student();
		
		//Handle NullPointerException when no student found with particular email
		try {
			student = entityManager.find(Student.class, sEmail);
		} catch(NullPointerException e) {
			e.printStackTrace();
		} 
		return student;
	}

	@Override
	public boolean validateStudent(String sEmail, String sPassword) {
		List<Student> allStd = getAllStudents();
		for (Student i: allStd) {
			
			if ((i.getsEmail().equals(sEmail)) && i.getsPass().equals(sPassword)){
				return true;
			}
		}
		return false;
	}

	@Override
	public void registerStudentToCourse(String sEmail, int cId) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("SMSBoston");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		Student std = new Student();
		Course course = new Course();
		
		//Handle NullPointerException when no data found for student and course
		try {
			std = entityManager.find(Student.class, sEmail);
			course = entityManager.find(Course.class, cId);
		} catch(NullPointerException e) {
			e.printStackTrace();
		}
		
		cList = getStudentCourses(sEmail);
		cList.add(course);
		
		std.setCourseList(cList);
		entityManager.persist(std);
		
		entityManager.getTransaction().commit();
		
	}

	@Override
	public List<Course> getStudentCourses(String sEmail) {
		Student s = getStudentByEmail(sEmail);
		List<Course> courseList = s.getCourseList();
		return courseList;
	}

}
