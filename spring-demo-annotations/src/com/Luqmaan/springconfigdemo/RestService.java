package com.Luqmaan.springconfigdemo;

import org.springframework.stereotype.Component;

@Component
public class RestService implements FortuneService {

	@Override
	public String getFortune() {
		// TODO Auto-generated method stub
		return "Rest Service";
	}

}
