package com.Deadlock;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Runner runner = new Runner();
		Thread t1 = new Thread(new Runnable()
		{
			public void run()
			{
				runner.firstThread();
			}
		});

		Thread t2 = new Thread(new Runnable()
		{
			public void run()
			{
				runner.secondThread();
			}
		});

		t1.start();
		t2.start();
		try{
			t1.join();
			t2.join();
		}
		catch(Exception e){e.printStackTrace();}
		
		runner.finish();
	}

}
