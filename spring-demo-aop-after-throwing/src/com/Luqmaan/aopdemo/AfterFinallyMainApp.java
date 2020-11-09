	package com.Luqmaan.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.Luqmaan.aopdemo.dao.AccountDAO;

public class AfterFinallyMainApp {

	public static void main(String[] args) {
		// read spring config java class
				AnnotationConfigApplicationContext context =
						new AnnotationConfigApplicationContext(DemoConfig.class);
				
				// get the bean from spring container
				AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
				
				// call method to find the accounts
				List<Account> theAccounts = null;
				
				try {
					// add a boolean flag to simulate exceptions
					boolean tripWire = false;
					theAccounts = theAccountDAO.findAccounts(tripWire);
				}
				catch (Exception exc) {
					System.out.println("\n\nMain Program ... caught exception: " + exc);
				}
				
				// display the accounts
				System.out.println("nMain Program: After Throwing DemoApp");
				System.out.println("----");
				
				System.out.println(theAccounts);
				
				System.out.println("\n");
				
				// close the context
				context.close();
			}


	}


