package com.Luqmaan.springconfigdemo;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {
	
	private String[] data = {
			"Hello",
			"I am Shaik Luqmaan",
			"MJCET"
			
	};
	
	private Random myRandom =new Random();

	@Override
	public String getFortune() {
		int number = myRandom.nextInt(data.length);
		
		String theFortune = data[number];
		
		return theFortune;
	
	}

}
