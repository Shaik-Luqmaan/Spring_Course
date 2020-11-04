package com.Luqmaan.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.Luqmaan.hibernate.demoentity.Course;
import com.Luqmaan.hibernate.demoentity.Instructor;
import com.Luqmaan.hibernate.demoentity.InstructorDetail;

public class EagerLazyDemo {
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
			
			System.out.println("Luqmaan: Instructor: " + tempInstructor);
			
			// get courses for the instructor
			System.out.println("Luqmaan : Courses: " + tempInstructor.getCourses());
	
			session.getTransaction().commit();
			
			System.out.println("Luqmaan :Done!");
		}
		finally {
			
			session.close();
			
			factory.close();
		}
	}

}
