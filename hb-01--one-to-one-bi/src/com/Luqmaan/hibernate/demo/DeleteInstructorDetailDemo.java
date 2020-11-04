package com.Luqmaan.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.Luqmaan.hibernate.demoentity.Instructor;
import com.Luqmaan.hibernate.demoentity.InstructorDetail;


public class DeleteInstructorDetailDemo {

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
					int id=3;
					InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class,id);
			
				
					System.out.println("deleteing temp instrutor deleting object..");
		
					//Remove bi-directional link
					
					tempInstructorDetail.getInstructor().setInstructorDetail(null);
					
					session.delete( tempInstructorDetail);
					
				
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
