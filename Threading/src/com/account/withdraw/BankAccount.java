package com.account.withdraw;

public class BankAccount {

	int amount = 100;

	public  void withdraw(int amt)
	{
		amount = amount -amt;
		
	}
	
	public int getBalance()
	{
		return amount;
	}
	
}
