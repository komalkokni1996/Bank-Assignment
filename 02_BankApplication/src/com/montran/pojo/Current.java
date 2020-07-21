package com.montran.pojo;

public class Current extends Account {
	private double overdraftBalance;
    private double tempOverDraftBalance;
   
    
	public Current() {
		// TODO Auto-generated constructor stub
	}
	
	public Current(int accountNumber, String name, double balance, double overdraftBalance) {
		super(accountNumber, name, balance);
		this.overdraftBalance = overdraftBalance;
		tempOverDraftBalance = overdraftBalance;
	}


	
	public double getOverdraftBalance() {
		return overdraftBalance;
	}

	public void setOverdraftBalance(double overdraftBalance) {
		this.overdraftBalance = overdraftBalance;
	}

	@Override
	public boolean withdraw(double amount) {
		if(amount > 0) {
			if( amount <= getBalance() ) {
				setBalance(getBalance() - amount);
				return true;
			}
			else if(amount <= (getBalance() + overdraftBalance)){
				amount = amount - getBalance();
				setBalance(0);
				setOverdraftBalance(overdraftBalance - amount);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean deposite(double amount) {
		if(amount > 0) {
			overdraftBalance = overdraftBalance + amount;
			if(overdraftBalance > tempOverDraftBalance) {
				setBalance(getBalance() + (overdraftBalance - tempOverDraftBalance));
				setOverdraftBalance(tempOverDraftBalance);
			}else {
				setOverdraftBalance(overdraftBalance);
				}
				return true;
			}
			return false;
		}

	@Override
	public String toString() {
		return "Current [overdraftBalance=" + overdraftBalance + ", getAccountNumber()=" + getAccountNumber()
				+ ", getName()=" + getName() + ", getBalance()=" + getBalance() + "]";
	}

}
