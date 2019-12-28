package com.account.withdraw;

public class RyanAndMonicaJob implements Runnable {

	private BankAccount account = new BankAccount();
	public static void main(String[] args) {

		RyanAndMonicaJob rm = new RyanAndMonicaJob();
		
		Thread t1 = new Thread(rm);
		Thread t2 = new Thread(rm);
		t1.setName("Ryan");
		t2.setName("Monica");
		t1.start();
		t2.start();	
	}

	@Override
	public void run() {
		for(int i=0;i < 10;i++)
		{
			withdrawAmount(10);	
			if(account.getBalance() < 0)
			{
				System.out.println(" Overdrawn ");
			}
		}
	}
	
	public synchronized void  withdrawAmount(int amount)
	{
		if(account.getBalance() >= amount)
		{
		    System.out.println(Thread.currentThread().getName() +" is about to withdraw");

		    System.out.println(Thread.currentThread().getName() +" is going to sleep..");
		    try{
				Thread.currentThread().sleep(2000);
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
		    
		    System.out.println(Thread.currentThread().getName() + " Woke up !!");			    
		    account.withdraw(amount);
		    System.out.println(Thread.currentThread().getName() + " Completes the Withdraw");
			
		    System.out.println(" Balance after withdrawl.." +account.getBalance());
		}
		else
		{
		    System.out.println(" Sorry not enough for " +Thread.currentThread().getName());
		}
		
	}
}
