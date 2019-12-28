package com.testSynchronized;

public class TestWithdraw {

	public static void main(String[] args) {
		Account a1 = new Account();
		Thread t1 = new Thread(a1);
		Thread t2 = new Thread(a1);
		t1.start();
		t2.start();
		t1.setName("Nishith");
		t2.setName("Aman");
	}
}

class Account implements Runnable{

	public int balance = 50;
	public void run()
	{
		for(int i = 0; i < 5; i++)
		{
		System.out.println("Thread running is: " +Thread.currentThread().getName());
		transact();
		}
	}

	public int checkBalance()
	{
		System.out.println("Remaining balance for " +Thread.currentThread().getName() + " is " + balance);
		return balance;
	}

	public void transact()
	{	
		if(checkBalance() > 0)
		{
			withdrawAmount();
		}
		else
		{
			System.out.println("Account Exausted !! for Thread " +Thread.currentThread().getName());
		}
		
	}
	
	public int withdrawAmount()
	{
		System.out.println("Processing withdrawal for " +Thread.currentThread().getName());
		 balance = balance - 10;
		 System.out.println("Balance after withdraw is: " +balance);
		 
		 return balance;
	}
	
}