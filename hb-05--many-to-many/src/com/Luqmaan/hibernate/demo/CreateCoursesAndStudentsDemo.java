package com.Luqmaan.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.Luqmaan.hibernate.demoentity.Course;
import com.Luqmaan.hibernate.demoentity.Instructor;
import com.Luqmaan.hibernate.demoentity.InstructorDetail;
import com.Luqmaan.hibernate.demoentity.Review;
import com.Luqmaan.hibernate.demoentity.Student;

public class CreateCoursesAndStudentsDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.addAnnotatedClass(Review.class)
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {			
			
			session.beginTransaction();
		
			int id = 2;
			Student tempStudent = session.get(Student.class,id);
			
			System.out.println("Saved Courses.."+tempStudent.getCourses());
			
			//More Courses
			
			Course tempCourse1 = new Course("How to Solve Rubiks Cube");
			Course tempCourse2 = new Course("Head First Design Pattern");
			
			tempCourse1.addStudent(tempStudent);
			tempCourse2.addStudent(tempStudent);
			
			
			session.save(tempCourse1);
			session.save(tempCourse2);	
			
			
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			
			// add clean up code
			session.close();
			
			factory.close();
		}
	}
}
