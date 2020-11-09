package com.Luqmaan.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.Luqmaan.aopdemo.Account;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
	
	// add a new advice for @AfterReturning on the findAccounts method
	
		@AfterReturning(
				pointcut="execution(* com.Luqmaan.aopdemo.dao.AccountDAO.findAccounts(..))",
				returning="result")
		public void afterReturningFindAccountsAdvice(
						JoinPoint theJoinPoint, List<Account> result) {
			
			// print out which method we are advising on 
			String method = theJoinPoint.getSignature().toShortString();
			System.out.println("Executing @AfterReturning on method: " + method);
					
			// print out the results of the method call
			System.out.println("Result is: " + result);
			
			//post-process the data
			
			// convert the account names to uppercase
			convertAccountNamesToUpperCase(result);

			System.out.println("Result in upper case is: " + result);
			
		}

		private void convertAccountNamesToUpperCase(List<Account> result) {

			// loop through accounts

			for (Account tempAccount : result) {
				
				// get uppercase version of name
				String theUpperName = tempAccount.getName().toUpperCase();
				
				// update the name on the account
				tempAccount.setName(theUpperName);
			}

		}


	
	@Before("com.Luqmaan.aopdemo.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice() {		
		System.out.println(" Executing demo @Before advice on method");		
	}
	
}
