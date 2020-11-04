package com.Luqmaan.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.Luqmaan.hibernate.demoentity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		// create session factory
				SessionFactory factory = new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(Student.class)
										.buildSessionFactory();
				
				// create session
				Session session = factory.getCurrentSession();
				
				try {			
					// create a student object
					System.out.println("Creating new student object...");
					Student tempStudent = new Student("Shaik", "Shafi", "shafi@gmail.com");
					
					// start a transaction
					session.beginTransaction();
					
					// save the student object
					System.out.println("Saving the student...");
					session.save(tempStudent);
					
					// commit transaction
					session.getTransaction().commit();
					
					
					//New Code
					System.out.println("Generated ID: "+tempStudent.getId());
					session =  factory.getCurrentSession();
					
					session.beginTransaction();
			
					Student myStudent = session.get(Student.class, tempStudent.getId());
					System.out.println(myStudent);
						
					session.getTransaction().commit();
					
					
					System.out.println("Done!");
				}
				finally {
					factory.close();
				}
			}
}
