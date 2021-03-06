package com.Luqmaan.springdemo;

public class CricketCoach implements Coach {
	
	private FortuneService fortuneservice;
	private String email;
	private String team;
	
	CricketCoach(){
		System.out.println("Constructor");
	}

	public void setFortuneService(FortuneService fortuneservice) {
		System.out.println("Setter method");
		this.fortuneservice = fortuneservice;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public void setTeam(String team) {
		this.team = team;
	}
	public String getTeam() {
		return team;
	}

	@Override
	public String getDaiyWorkout() {
	
		return "Do 20 pushups";
	}

	@Override
	public String getDailyFortune() {
	
		return fortuneservice.getFortune();
	}

}
