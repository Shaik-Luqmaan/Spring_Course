package com.Luqmaan.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.Luqmaan.hibernate.demoentity.Instructor;
import com.Luqmaan.hibernate.demoentity.InstructorDetail;


public class GetInstructorDemo {

	public static void main(String[] args) {
	
				SessionFactory factory = new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(Instructor.class)
										.addAnnotatedClass(InstructorDetail.class)
										.buildSessionFactory();
				
		
				Session session = factory.getCurrentSession();
				
				try {	
					
					session.beginTransaction();
					
					//get Instructor detail object
					int id=2;
					InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class,id);
			
					//print instructor detail

					System.out.println(tempInstructorDetail);
					
					//print associated instructor
					
					System.out.println(tempInstructorDetail.getInstructor());
					
					session.getTransaction().commit();
					
					System.out.println("Done!");
				}
				catch(Exception e) {
					e.printStackTrace();
				}
				finally {
					session.close();
					factory.close();
				}
			}
}
