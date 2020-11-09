package com.Luqmaan.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.Luqmaan.aopdemo.dao.AccountDAO;
import com.Luqmaan.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// read spring config java class
				AnnotationConfigApplicationContext context =
						new AnnotationConfigApplicationContext(DemoConfig.class);
				
		// get the beans from spring container
				AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
				
				MembershipDAO theMembershipDAO = 
						context.getBean("membershipDAO", MembershipDAO.class);
				
				Account theAccount = new Account();
				
		// call the business method
				theAccountDAO.addAccount(theAccount);
			

				System.out.println("\n Calling Again...\n");
				
		// call the membership method again
				theMembershipDAO.addAccount();
						
		// close the context
				context.close();

	}

}
