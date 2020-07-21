package com.montran.main;

import com.montran.pojo.Account;
import com.montran.pojo.Savings;

public class AccountMainv4 {

	public static void main(String[] args) {
		// calling default constructor
				// Account account = new Account();

			//	Account account = new Account(101, "Vivek", 1000);

			//	System.out.println(account);
		
		Savings savings = new Savings(101,"komal",10000,true);
		System.out.println(savings);
	}

}
