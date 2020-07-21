package com.montran.main;

import java.util.Scanner;

import com.montran.pojo.Account;

public class AccountMainV3 {

	public static void main(String[] args) {
	   
		Scanner scanner = new Scanner(System.in);
		
		int accounNumber;
		String name;
		double balance;
		int transactionChoice;
		int amount;
		String continueChoice;
		boolean result;
		
		System.out.println("Hello Welcome to XYZ Bank..!!");
		System.out.println("Enter A/C No. :");
		accounNumber = scanner.nextInt();
		
		System.out.println("Enter Name. :");
		name = scanner.next();
		
		System.out.println("Enter Balance. :");
		balance = scanner.nextDouble();
		
		
		Account account = new Account();
		
		do {
		System.out.println("Menu");
		System.out.println("1.Withdraw");
		System.out.println("2.Deposite");
		System.out.println("3.Balance");
		
		System.out.println("Enter Choice: ");
		transactionChoice = scanner.nextInt();
		
		switch (transactionChoice) {
		case 1: 
			System.out.println("Enter Amount to Withdraw: ");
			amount = scanner.nextInt();
			result = account.withdraw(amount);
			if(result) 
				System.out.println("Transaction Successful");
			else 
				System.out.println("Transaction Failed");
			break;
	
		case 2: 
			System.out.println("Enter Amount to Diposite: ");
			amount = scanner.nextInt();
			result = account.deposite(amount);
			if(result) 
				System.out.println("Transaction Successful");
			else 
				System.out.println("Transaction Failed");
			break;
		
		case 3:
			System.out.println("Account Balance :: " + account.getBalance());
			break;
		default:
			System.out.println("Invalid Option");
			break;
		}
	
		System.out.println("Do you want to continue ?");
		continueChoice = scanner.next();
	} while (continueChoice.equals("yes"));
		scanner.close();

   }
	
}