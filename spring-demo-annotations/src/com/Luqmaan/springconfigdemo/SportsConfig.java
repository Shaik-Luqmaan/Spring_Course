package com.Luqmaan.springconfigdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
//@ComponentScan("com.Luqmaan.springconfigdemo")
@PropertySource("classpath:sports.properties")
public class SportsConfig {
	
	@Bean
	public FortuneService sadForutuneService() {
		return new SadFortuneService();
	}

	@Bean
	//swimCoach is the beanId
	public Coach swimCoach() {
		return  new SwimCoach(sadForutuneService());
	}
	
}
