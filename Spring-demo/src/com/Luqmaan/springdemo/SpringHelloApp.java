package com.Luqmaan.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringHelloApp {
	
	  public static void main(String[] args) {

		//Load configuration files
		  
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//Retrieve bean from container
		
		Coach theCoach = context.getBean("myCoach", Coach.class);
		
		//Call methods to bean
		
		System.out.println(theCoach.getDaiyWorkout());
		System.out.println(theCoach.getDailyFortune());
		
		//Close the context
		
		context.close();
	}

}
