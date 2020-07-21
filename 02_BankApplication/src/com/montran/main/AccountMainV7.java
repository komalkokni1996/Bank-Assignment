package com.montran.main;

import java.util.Scanner;

import com.montran.pojo.Current;
import com.montran.pojo.Savings;

public class AccountMainV7 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int accountNumber = 0;
		String name="";
		double balance=0;
		int amount;
		int trainsactionChoice;
		String continueChoice;
		int accountChoice;
		boolean isSalary = false;
		boolean result;
		double overdraftBalance=0;
		boolean isCurrent = false;
		
		System.out.println(" Hello Welcome to XYZ Bank !!");
		System.out.println("--------------------------------------------");
		System.out.println("\n----Menu-----");
		System.out.println("1.. Savings");
		System.out.println("2.. Current");
		System.out.println("Enter your choice: ");
		accountChoice = scanner.nextInt();

		switch (accountChoice) {
		case 1:
			System.out.println("Do you want to open salary account (true-false): ");
			isSalary = scanner.nextBoolean();
			break;
		case 2:
			//System.out.println("Work in progress !!");
			isCurrent =true;
			System.out.println("Enter OverdraftBalance: ");
			overdraftBalance = scanner.nextDouble();
			break;
		default:
			break;
		}

		System.out.println("Enter Account Number: ");
		accountNumber = scanner.nextInt();

		System.out.println("Enter Name: ");
		name = scanner.next();

		System.out.println("Enter Balance: ");
		balance = scanner.nextDouble();

		System.out.println("Your Account is Opened Successfully !!");
		
		if(isCurrent == true) {
		System.out.println("\n-----------------Account Details------------------");
		System.out.println("Account No. : " + accountNumber);
		System.out.println("Name : " + name);
		System.out.println("Balance : Rs.  " + balance);
		System.out.println("OverDraft Balance : Rs.  " + overdraftBalance);
		}
		else {
			System.out.println("\n-----------------Account Details------------------");
			System.out.println("Account No. : " + accountNumber);
			System.out.println("Name : " + name);
			System.out.println("Balance : Rs. " + balance);
		}
			
		Savings savings = new Savings(accountNumber, name, balance, isSalary);
		
		Current current = new Current(accountNumber, name, balance, overdraftBalance);
		
		do {
			System.out.println("\n----Menu-----");
			System.out.println("1. Withdraw");
			System.out.println("2. Deposit");
			System.out.println("3. Balance");
			System.out.println("Enter your choice: ");
			trainsactionChoice = scanner.nextInt();

			switch (trainsactionChoice) {
			case 1:
				
				System.out.println("Enter Amount to withdraw: ");
				amount = scanner.nextInt();
				result = savings.withdraw(amount);
				if (result)
					System.out.println("Transaction Success !!");
				else
					System.out.println("Transaction Failed !!");
				break;
			case 2:
				
				System.out.println("Enter Amount to deposit: ");
				amount = scanner.nextInt();
				result = savings.deposite(amount);
				if (result)
					System.out.println("Transaction Success !!");
				else
					System.out.println("Transaction Failed !!");
				break;
			case 3:
				if( isCurrent == true) {
				System.out.println("Account Balance :: Rs. " + current.getBalance());
				System.out.println("OverDraft Balance:: Rs.  " + current.getOverdraftBalance());
				}
				else {
				System.out.println("Account Balance :: Rs. " + savings.getBalance());
				}
				break;
			default:
				System.out.println("Invalid choice");
				break;
			}
			System.out.println("-----------------------------------");
			System.out.println("Do you want to continue ?");
			continueChoice = scanner.next();
		} while (continueChoice.equals("yes"));
		if (continueChoice.equals("no")){
			System.out.println("-----------------------------------");
			System.out.println("Thank You For Banking With Us !!");
		}
		scanner.close();

	}

}
