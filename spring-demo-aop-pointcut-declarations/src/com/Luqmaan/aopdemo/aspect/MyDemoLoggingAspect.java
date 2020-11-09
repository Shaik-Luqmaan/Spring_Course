package com.Luqmaan.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	
	//Pointcut declarataion
	@Pointcut("execution(* com.Luqmaan.aopdemo.dao.*.*(..))")
	private void forDaoPackage() {}

	// this is where we add all of our related advices for logging
	//Run this code before addAccount method
	@Before("execution(* add*(..))")
	public void beforeAddAccountAdvice() {
		
		System.out.println("Executing @Before advice on addAccount()");
		
	}
	@Before("forDaoPackage()")
	public void performApiAnalytics() {
		System.out.println("\nPerforming API analytics");		
	}
}
