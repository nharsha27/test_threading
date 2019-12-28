package thread.tutorial.lessson3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// synchronized code blocks and multiple locks
public class Main {

	List<Integer> list1 = new ArrayList<Integer>();
	List<Integer> list2 = new ArrayList<Integer>();
	
	public static void main(String[] args) {
		Main m1 = new Main();
		System.out.println("Starting..");
		long start_time= System.currentTimeMillis(); 
		for(int i = 0; i < 1000; i++)
		{
			m1.processOne();
			m1.processTwo();
		}
		long end_time = System.currentTimeMillis();
		long total_time = end_time - start_time;
		System.out.println("Total time taken: " +total_time);
		System.out.println("Total Elements:  -->>> " +m1.list1.size() + " - " +m1.list2.size());
		
	}
	
	
	public void processOne()
	{
		Random rand = new Random();
		
		list1.add(rand.nextInt());
	}
	
	public void processTwo()
	{
		Random rand = new Random();
		
		list2.add(rand.nextInt());
	}

}
