package com.Luqmaan.springconfigdemo;

import org.springframework.stereotype.Component;

@Component
public class DatabaseService implements FortuneService {

	@Override
	public String getFortune() {
		// TODO Auto-generated method stub
		return "DB Service";
	}

}
