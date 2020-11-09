package com.Luqmaan.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.Luqmaan.aopdemo.Account;

@Component
public class AccountDAO {

	public void addAccount(Account theAccount) {
		
		System.out.println("DOING MY DB WORK: ADDING AN ACCOUNT");
		
	}
}
