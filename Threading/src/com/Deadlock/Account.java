package com.Deadlock;

public class Account {

	public int amount = 10000;
	
	public void withdraw(int amt)
	{
		amount = amount - amt;
	}
	
	public void deposit(int amt)
	{
		amount = amount +amt;
	}
	
	public int getBalance()
	{
		return amount;
	}
	
	public static void transfer(Account acc1, Account acc2, int balance)
	{
		acc1.withdraw(balance);
		acc2.deposit(balance);
	}
	
}
