package com.testSynchronized;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Worker {

	List<Integer> list1 = new ArrayList<Integer>();
	List<Integer> list2 = new ArrayList<Integer>();
	
	private Object lock1 = new Object();
	private Object lock2 = new Object();
	
	Random random = new Random();
	public void processOne()
	{
		synchronized(lock1){
		try {
			Thread.sleep(1);
		
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		list1.add(random.nextInt(100));
	}
	
	public  void processTwo()
	{
		synchronized(lock2){
		try {
			Thread.sleep(1);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		list2.add(random.nextInt(100));
	}
	
	
	public void processData()
	{
		for(int i = 0 ; i < 1000 ; i++)
		{
			processOne();
			processTwo();
		}
	}
	
	public void main()
	{
		System.out.println("Starting...");
		long start = System.currentTimeMillis();
		Thread t1 = new Thread(new Runnable()
				{
					@Override
					public void run() {
						processData();
								}
				});
		
		Thread t2 = new Thread(new Runnable()
		{
			@Override
			public void run() 
			    {
				processData();
				}
		});
		
		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		long end = System.currentTimeMillis();
		System.out.println(" Size is: " +list1.size()+ " " +list2.size());
		System.out.println("Total time taken is: " +(end-start));
	}
}
