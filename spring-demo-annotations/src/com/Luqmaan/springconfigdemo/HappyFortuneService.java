package com.Luqmaan.springconfigdemo;

import org.springframework.stereotype.Component;

@Component
public class HappyFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "Today you will win the match"	;
	}

}
