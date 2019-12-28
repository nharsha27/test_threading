package com.Deadlock;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Runner {

	Account acc1 = new Account();
	Account acc2 = new Account();
	private Lock lock1 = new ReentrantLock();
	private Lock lock2 = new ReentrantLock();
	
	
	public void tryLock(Lock firstLock, Lock secondLock)
	{
		
		while(true){
		boolean gotfirstLock = false;
		boolean gotsecondLock = false;
		
		try{
			gotfirstLock = firstLock.tryLock();
			gotsecondLock = secondLock.tryLock();
		}
		finally{
			if(gotfirstLock && gotsecondLock)
			{
				return;
			}	
		if(gotfirstLock)
		{
			firstLock.unlock();
		}
		if(gotsecondLock)
		{
			secondLock.unlock();
		}
		}
		
		}
	}
  public void firstThread()
  {
	for(int i=0; i < 10000 ; i++)
	{
		Random random = new Random();
		tryLock(lock1, lock2);
		try{
			Account.transfer(acc1, acc2, random.nextInt(100));	
		}
		finally{
			lock1.unlock();
			lock2.unlock();
		}
		
	}
  }
  
  public void secondThread()
  {
	  for(int i=0; i < 10000 ; i++)
		{
		
	  Random random = new Random();
	  tryLock(lock1, lock2);
		
		try{
			Account.transfer(acc2, acc1, random.nextInt(100));	
		}
		finally{
			lock1.unlock();
			lock2.unlock();
		}
		
		}
  }
  
 
  
  public void finish()
  {
	System.out.println("Account 1 balance: " +acc1.getBalance()); 
	System.out.println("Account 2 balance: " +acc2.getBalance());
	System.out.println("Total balance: " +(acc1.getBalance() + acc2.getBalance()));
  }

}
