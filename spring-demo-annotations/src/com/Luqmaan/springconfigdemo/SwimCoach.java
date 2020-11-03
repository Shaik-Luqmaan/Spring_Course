package com.Luqmaan.springconfigdemo;

import org.springframework.beans.factory.annotation.Value;

public class SwimCoach implements Coach {
	
	private FortuneService theFortuneService;
	
	@Value("${foo.email}")
	private String email;
	
	@Value("${foo.team}")
	private String team;
	
	SwimCoach(FortuneService theFortuneService){
		this.theFortuneService = theFortuneService;
	}

	@Override
	public String getDaiyWorkout() {
		return "Swim 5 laps";
	}

	@Override
	public String getDailyFortune() {
		return theFortuneService.getFortune();
	}

	public String getEmail() {
		return email;
	}

	public String getTeam() {
		return team;
	}

	
}
