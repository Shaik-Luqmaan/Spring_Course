package com.Luqmaan.springdemo;

public class TrackCoach implements Coach {
	private FortuneService fortuneservice;
	
		TrackCoach(){}
	
		public TrackCoach(FortuneService fortuneservice) {
		//super();
		this.fortuneservice = fortuneservice;
	}

		@Override
	public String getDaiyWorkout() {
		// TODO Auto-generated method stub
		return "Run hard for 5km";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return "Common ON ! " + fortuneservice.getFortune();
	}
	
	public void doMyStartupStuff() {
		System.out.println("Things to do befor starting");
	}
	
	public void doMyClosingStuff() {
		System.out.println("Before clossing stuff");
	}

}
