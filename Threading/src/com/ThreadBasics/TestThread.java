package com.ThreadBasics;

import java.util.Scanner;

class Runner extends Thread
{
	public volatile boolean running = true; // volatile keyword prevents methods from caching the values 
	public void run()
	{
		while(running)
		{
			System.out.println("true");
			try {
				Thread.sleep(1000);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}

	public void shutdown()
	{
		System.out.println("shutting down...");
		running = false;
	}
}

public class TestThread {
	public static void main(String[] args) {
		Runner r1 = new Runner();
		Thread t1 = new Thread(r1);
		t1.start();

		Scanner s1 = new Scanner(System.in);
		s1.nextLine();
		
		
        r1.shutdown();

	}
}
