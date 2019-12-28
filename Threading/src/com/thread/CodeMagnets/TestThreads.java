package com.thread.CodeMagnets;

public class TestThreads {

	public static void main(String[] args) {

		ThreadOne t1 = new ThreadOne();
		ThreadTwo t2 = new ThreadTwo();

		Thread one = new Thread(t1);
		Thread two = new Thread(t2);	

		one.start();
		two.start();
	}

}
class Accum{

	private Accum()
	{

	}

	private static Accum getAccum(){
		return null;

	}
}

class ThreadOne implements Runnable{

	@Override
	public void run() {
		for(int x = 0;x < 99 ; x++)
		{

		}

	}
}

class ThreadTwo implements Runnable{

	@Override
	public void run() {

		for(int x = 0; x < 98 ; x++)
		{

		}

	} 
}


