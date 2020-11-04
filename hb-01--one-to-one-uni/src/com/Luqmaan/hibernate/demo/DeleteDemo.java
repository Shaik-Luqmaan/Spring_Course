package com.Luqmaan.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.Luqmaan.hibernate.demoentity.Instructor;
import com.Luqmaan.hibernate.demoentity.InstructorDetail;
import com.Luqmaan.hibernate.demoentity.Student;

public class DeleteDemo {

	public static void main(String[] args) {
	
				SessionFactory factory = new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(Instructor.class)
										.addAnnotatedClass(InstructorDetail.class)
										.buildSessionFactory();
				
		
				Session session = factory.getCurrentSession();
				
				try {	
					int id=1;
					
					session.beginTransaction();
					
					Instructor tempInstructor = session.get(Instructor.class, id);
					
					if(tempInstructor != null) {
						System.out.println("Deleting....");
						session.delete(tempInstructor);
					}
					
					
					session.getTransaction().commit();
					
					System.out.println("Done!");
				}
				finally {
					factory.close();
				}
			}
}
