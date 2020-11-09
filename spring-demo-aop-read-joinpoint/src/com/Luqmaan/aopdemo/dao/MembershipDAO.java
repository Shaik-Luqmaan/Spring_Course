package com.Luqmaan.aopdemo.dao;


import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

	public boolean addSillyMember() {
		
		System.out.println("DOING STUFF: ADDING A MEMBERSHIP ACCOUNT");
		
		return true;
	}

	public void goToSleep() {
		
		System.out.println("I'm going to sleep now...");
		
	}

}

