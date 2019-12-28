package com.Producer_Comsumer;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Processor {

	Object lock = new Object();
	LinkedList<Integer> list = new LinkedList<>();
	public void Produce() throws InterruptedException
	{
		Random random = new Random();
		int value = 0;
		while(true)
		{
			synchronized (lock) { // aquired intransic lock

				while(list.size() == 10) {
					lock.wait();	
				}
				System.out.println(Thread.currentThread().getName() + " adding values..");
				list.add(value++);
			}		
		}
	}


	public void Consume() throws InterruptedException
	{
		Random random = new Random();
		while(true)
		{
			// Thread.sleep(2000);
			synchronized (lock) {
				while(list.size() == 0){
					lock.wait();}
				System.out.print(Thread.currentThread().getName() + "List size is: " +list.size());
				int value = list.removeFirst();
				System.out.println(" removed value: " +value);
				lock.notify();
			}

			Thread.sleep(random.nextInt(1000));
		}
	}
}
