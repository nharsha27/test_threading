package com.PoolThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class testPooling implements Runnable{


	private int id;

	public testPooling(int id)
	{
		this.id = id;
	}

	public void run()
	{
		System.out.println("Starting task: " +id);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Ending task: " +id);
	}
	
	public static void main(String[] args) {
	
		ExecutorService executorServ = Executors.newFixedThreadPool(2);
		for(int i = 1 ; i <= 5 ; i++)
		{
			executorServ.submit(new testPooling(i));
		}
		
		executorServ.shutdown();
		
		try {
			executorServ.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(" All task completed...");
	}

}
