package com.Producer_Comsumer;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class App {

	public static BlockingQueue<Integer> bQueue = new ArrayBlockingQueue<Integer>(10);
	public static Processor p1 = new Processor();
	
	public static void main(String[] args) {

		Thread t1 = new Thread(new Runnable()
		{public void run()
			{try {
				p1.Produce();
				//Producer();
				} catch (InterruptedException e) {e.printStackTrace();}}
		});

		Thread t2 = new Thread(new Runnable()
		{public void run()
			{try {
				p1.Consume();
				//Consumer();
			} catch (InterruptedException e) {e.printStackTrace();}}
		});
		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		}
		catch(Exception e)
		{e.printStackTrace();}
	}


	public static void Producer() throws InterruptedException
	{
		Random random = new Random();	
		while(true){
			int value = random.nextInt(100);
			bQueue.put(value);
			System.out.println("adding value: " +value+ " Queue size is: " +bQueue.size());
		}
	}

	public static void Consumer() throws InterruptedException
	{
		while(true){
			Thread.sleep(100);
			Random random = new Random();
			if(random.nextInt(10) == 0){
				Integer value = bQueue.take();
				System.out.println("Taken value: " +value+ " Queue size is: " +bQueue.size());
			}
		}
	}
}
