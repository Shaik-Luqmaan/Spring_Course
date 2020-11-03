package com.Luqmaan.springdemo;

public class BaseballCoach implements Coach{
	
	private FortuneService fortuneservice;
	
	public BaseballCoach(FortuneService thefortuneservice) {
		fortuneservice = thefortuneservice;
	}
	
	@Override
	public String getDaiyWorkout() {
		return "Spent more time in running practice";
	}

	@Override
	public String getDailyFortune() {
	
		return fortuneservice.getFortune();  // dependency = helper
	}

}
