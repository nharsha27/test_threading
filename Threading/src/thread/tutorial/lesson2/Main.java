package thread.tutorial.lesson2;

public class Main {

	public int counter=0;
	public static void main(String[] args) {

		Main m1 = new Main();		
		m1.test();
	}
	
	public synchronized void increment()
	{
		counter = counter+1;
	}

	public void test() {

		Thread t1 = new Thread(new Runnable()
		{
			public void run()
			{
				for(int i =0 ; i < 10000; i++)
				{
					//counter++;
					increment();
				}
			}
		});


		Thread t2 = new Thread(new Runnable()
		{
			public void run()
			{
				for(int i =0 ; i < 10000; i++)
				{
					//counter++;
					increment();
				}
			}
		});

		t1.start();
		t2.start();

		try{
			t1.join();
			t2.join();
		}
		catch(InterruptedException er)
		{
			er.printStackTrace();
		}

		System.out.println("Value of counter is: " +counter);
	}
}

