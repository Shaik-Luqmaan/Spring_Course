package com.Luqmaan.springconfigdemo;

public class SadFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "Not your Day...!";
	}

}
