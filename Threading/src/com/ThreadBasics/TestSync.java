package com.ThreadBasics;

public class TestSync {
	int count =0;
	
	// if we call the syncronized method of the object, we have to aquire the intransic lock before you can call it
	// and only one thread at time can aquire the intransic lock at a time
public synchronized void increment() {
	count++;
}
	public static void main(String[] args) {

		TestSync ts = new TestSync();
		ts.test();
	}

	public void test()
	{
		Thread t1 = new Thread(new Runnable() {
			public void run()
			{
				for(int i = 0 ; i < 10000 ; i++)
				{
					increment();
				}
			}
		});

		Thread t2 = new Thread(new Runnable() {
			public void run()
			{
				for(int i = 0 ; i < 10000 ; i++)
				{
					increment();
				}
			}
		});

		t1.start();
		t2.start();
		
		try{t1.join();t2.join();}
		catch(Exception e){e.printStackTrace();}
		
		System.out.println("Value of count us: " +count);

	}

}
