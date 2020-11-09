package com.Luqmaan.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.Luqmaan.aopdemo.Account;

@Component
public class AccountDAO {

	public void addAccount(Account theAccount,boolean flag) {
		
		System.out.println("DOING MY DB WORK: ADDING AN ACCOUNT");
		}
	
	public boolean doWork() {
		
		System.out.println("Do Work method");
		return false;
	}
}


