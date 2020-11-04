package com.Luqmaan.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.Luqmaan.hibernate.demoentity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		// create session factory
				SessionFactory factory = new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(Student.class)
										.buildSessionFactory();
				
				// create session
				Session session = factory.getCurrentSession();
				
				try {			
					
					// start a transaction
					session.beginTransaction();
					
					//query student objects from database
					
				List<Student> theStudents = 
						session.createQuery("from Student").getResultList();
				//Use class name Student in createQuery
					
				displayStudents(theStudents); //Extracted for each loop n display method
				
				//first Name=Shaik or lastName=Luqmaan
				theStudents = 
						session.createQuery("from Student s where"
						+ " s.firstName='Shaik' AND s.lastName='Luqmaan '").getResultList();
				
				displayStudents(theStudents);
				
				//email matches gmail.com
				theStudents = 
						session.createQuery("from Student s where s.email LIKE '%gmail.com'").getResultList();
				displayStudents(theStudents);
				
					// commit transaction
					session.getTransaction().commit();
					
					System.out.println("Done!");
				}
				finally {
					factory.close();
				}
			}

	private static void displayStudents(List<Student> theStudents) {
		for(Student s: theStudents) {
			System.out.println(s);
		}
	}
}
