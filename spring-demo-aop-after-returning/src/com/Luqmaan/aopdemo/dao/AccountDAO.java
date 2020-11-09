package com.Luqmaan.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.Luqmaan.aopdemo.Account;

@Component
public class AccountDAO {
	
	private String name;
	private String servieCode;
	
	
	// add a new method: findAccounts()
	
		public List<Account> findAccounts() {
			
			List<Account> myAccounts = new ArrayList<>();
			
			// create sample accounts
			Account temp1 = new Account("John", "Silver");
			Account temp2 = new Account("Madhu", "Platinum");
			Account temp3 = new Account("Luca", "Gold");
			
			// add them to our accounts list
			myAccounts.add(temp1);
			myAccounts.add(temp2);
			myAccounts.add(temp3);
			
			
			return myAccounts;		
		}
		

	public void addAccount(Account theAccount,boolean flag) {
		
		System.out.println("DOING MY DB WORK: ADDING AN ACCOUNT");
		}
	
	public boolean doWork() {
		
		System.out.println("Do Work method");
		return false;
	}

	public String getName() {
		System.out.println("Get name");
		
		return name;
	}

	public void setName(String name) {
		System.out.println("Set name");
		this.name = name;
	}

	public String getServieCode() {
		System.out.println("Get code");
		return servieCode;
	}

	public void setServieCode(String servieCode) {
		System.out.println("Set code");
		this.servieCode = servieCode;
	}
	
	
}


