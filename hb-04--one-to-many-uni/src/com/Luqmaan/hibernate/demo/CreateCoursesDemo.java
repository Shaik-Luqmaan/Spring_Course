package com.Luqmaan.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.Luqmaan.hibernate.demoentity.Course;
import com.Luqmaan.hibernate.demoentity.Instructor;
import com.Luqmaan.hibernate.demoentity.InstructorDetail;

public class CreateCoursesDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {			
			
			session.beginTransaction();
			
			// get the instructor from db
			int theId = 1;
			Instructor tempInstructor = session.get(Instructor.class, theId);		
			
			// create some courses
			Course tempCourse1 = new Course("Spring Courses");
			Course tempCourse2 = new Course("Hibernate Course");
			
			// add courses to instructor
			tempInstructor.add(tempCourse1);
			tempInstructor.add(tempCourse2);
			
			// save the courses
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
