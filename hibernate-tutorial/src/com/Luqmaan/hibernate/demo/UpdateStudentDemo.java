package com.Luqmaan.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.Luqmaan.hibernate.demoentity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		// create session factory
				SessionFactory factory = new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(Student.class)
										.buildSessionFactory();
				
				// create session
				Session session = factory.getCurrentSession();
				
				try {			
							
					int studentId = 1;
					
					System.out.println("Generated ID: " + studentId);
					session =  factory.getCurrentSession();
					
					session.beginTransaction();
			
					Student myStudent = session.get(Student.class, studentId);
					
					//Updating
					System.out.println("Updating Student..");
					myStudent.setFirstName("Shaaaaik");
						
					session.getTransaction().commit();
					
					//UPDATE ALL THE STUDENT OBJECTS
					//Another way to update using create query
					//executeQuery() used for update and delete
					
					session =  factory.getCurrentSession();
					
					session.beginTransaction();
					
					session.createQuery("update Student set email = 'foo@gmail.com '")
							.executeUpdate();
					
					
					session.getTransaction().commit();
					
					
					
					
					System.out.println("Done!");
				}
				finally {
					factory.close();
				}
			}
}
