package com.Luqmaan.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.Luqmaan.aopdemo.dao.AccountDAO;
import com.Luqmaan.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		// read spring config java class
				AnnotationConfigApplicationContext context =
						new AnnotationConfigApplicationContext(DemoConfig.class);
				
				// get the bean from spring container
				AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
				
				// get membership bean from spring container
				MembershipDAO theMembershipDAO = 
						context.getBean("membershipDAO", MembershipDAO.class);
						
				// call the business method
				Account myAccount = new Account();
				theAccountDAO.addAccount(myAccount, true);
				theAccountDAO.doWork();
				
				//Call getter and setter
				theAccountDAO.setName("Luqmaan");
				theAccountDAO.setServieCode("IFSC");
				
				theAccountDAO.getName();
				theAccountDAO.getServieCode();
				
				// call the membership business method
				theMembershipDAO.addSillyMember();
				theMembershipDAO.goToSleep();
				
			
				
				
				// close the context
				context.close();
			}

}
