package com.Luqmaan.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.Luqmaan.hibernate.demoentity.Instructor;
import com.Luqmaan.hibernate.demoentity.InstructorDetail;
import com.Luqmaan.hibernate.demoentity.Student;

public class CreateDemo {

	public static void main(String[] args) {
	
				SessionFactory factory = new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(Instructor.class)
										.addAnnotatedClass(InstructorDetail.class)
										.buildSessionFactory();
				
		
				Session session = factory.getCurrentSession();
				
				try {	
					
					Instructor tempInstructor = new Instructor("Shaik","Luqmaan","obaid@gmail.com");
					InstructorDetail tempInstructorDetail = 
							new InstructorDetail("Luqmaaaaaaaan","Sports");
					
					
					session.beginTransaction();
					
					//Joining both the objects
					tempInstructor.setInstructorDetail(tempInstructorDetail);
					
					//This will also save instructor details as we are using cascading ALL
					session.save(tempInstructor);
					
					session.getTransaction().commit();
					
					System.out.println("Done!");
				}
				finally {
					factory.close();
				}
			}
}
