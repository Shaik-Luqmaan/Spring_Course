package com.Luqmaan.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.Luqmaan.hibernate.demoentity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {
		// create session factory
				SessionFactory factory = new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(Student.class)
										.buildSessionFactory();
				
				// create session
				Session session = factory.getCurrentSession();
				
				try {			
							
					int studentId = 2;
					
					System.out.println("Generated ID: " + studentId);
					session =  factory.getCurrentSession();
					
					session.beginTransaction();
			
					Student myStudent = session.get(Student.class, studentId);
					
					//Delete student object
					System.out.println("Deleting Student..");
					session.delete(myStudent);
						
					session.getTransaction().commit();
					
			
					//Another way to delete using create query
					//executeQuery() used for update and delete
					
					session =  factory.getCurrentSession();
					
					session.beginTransaction();
					
					session.createQuery("delete from Student where id = 5 ")
							.executeUpdate();
					
					
					session.getTransaction().commit();
					
					System.out.println("Done!");
				}
				finally {
					factory.close();
				}
			}
}
