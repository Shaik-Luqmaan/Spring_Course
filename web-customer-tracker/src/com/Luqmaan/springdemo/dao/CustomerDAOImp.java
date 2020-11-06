	package com.Luqmaan.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.Luqmaan.springdemo.entity.Customer;

@Repository
public class CustomerDAOImp implements CustomerDAO {

	//Inject session factory for DAO
	@Autowired
	private SessionFactory sessionFactory;	
	
	@Override
	public List<Customer> getCustomers() {
		
		//Get current hibernate session
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		//Create Query
		
		Query<Customer> theQuery = currentSession.createQuery("from Customer order	by firstName"
														, Customer.class);
		
		
		//Exceute query
		
		List<Customer> customers = theQuery.getResultList();
		
		
		//Retrive Result
		
		return customers;
					
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		
		//get current session
	
		Session currentSession = sessionFactory.getCurrentSession();
		
		//save Customer to db
		currentSession.saveOrUpdate(theCustomer);
		
	}

	@Override
	public Customer getCustomer(int theId) {
	
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
				
		// now retrieve/read from database using the primary key
		Customer theCustomer = currentSession.get(Customer.class, theId);
				
		return theCustomer;
		
	}

	@Override
	public void deleteCustomer(int theId) {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
				
		// delete object with primary key
		Query theQuery = 
						currentSession.createQuery("delete from Customer where id=:customerId");
		
		theQuery.setParameter("customerId", theId);
				
		theQuery.executeUpdate();	
		
	}

}
