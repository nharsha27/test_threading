package thread.tutorials.lesson1;

import java.util.Scanner;

public class Main {

	public static void main(String args[])
	{
		Runner r1 = new Runner();
		r1.start();
		Scanner s1 = new Scanner(System.in);
		System.out.println("Press enter to stop");
		s1.nextLine();

		r1.shutdown();
	}

}

class Runner extends Thread
{
	public volatile boolean running = true; 
	/* This value might be cached
	 *  my the running thread hence when we try to
	stop the thread it might take the old value

	 -->> Running..Thread-0
     -->>> Stopping... Stopping.. by main
     -->> Running..Thread-0
	 */

	public void run()
	{
		while(running)
		{
			System.out.println(" -->> Running.. " +Thread.currentThread().getName());
		}
	}

	public void shutdown()
	{
		System.out.println(" -->>> Stopping... Stopping.. by" +Thread.currentThread().getName());
		running = false;
	}
}


