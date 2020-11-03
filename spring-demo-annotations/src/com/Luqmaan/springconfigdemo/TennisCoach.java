package com.Luqmaan.springconfigdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


@Component
public class TennisCoach implements Coach {
	
	@Autowired
	@Qualifier("randomFortuneService")
	
	private FortuneService theFortuneService;
	
	TennisCoach(){
		System.out.println("Default Constructor");
	}
	/*
	 * PostConstruct and PreDestroy have been deprecated for java 10 and above
	@PostConstruct
	public void doSomething() {
		System.out.println("Before initialization");
	}
	
	@PreDestroy
	public void doBeforeDestroy() {
		System.out.println("Before Destroy");
	}*/

	/*
	@Autowired (Constructor Injection)
	TennisCoach(FortuneService theFortuneService){
		this.theFortuneService = theFortuneService;
	}
	
	@Autowired (Setter Injection)
	public void setTheFortuneService(FortuneService theFortuneService){
		this.theFortuneService = theFortuneService;
	}
	
	@Autowired
	public void methodInjection(FortuneService theFortuneService){
		this.theFortuneService = theFortuneService;
	}
*/
	@Override
	public String getDaiyWorkout() {
		return "Pratice your backhand shot";
	}

	@Override
	public String getDailyFortune() {
		return theFortuneService.getFortune();
	}

	
	
}
