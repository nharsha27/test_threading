package com.NameList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Check c1 = new Check();
		c1.addElement("Nishith");
		c1.addElement("Shrey");
		c1.addElement("Naveen");
		c1.addElement("Papa");
		c1.addElement("Mom");
		c1.addElement("Savan");
		

		class testCheck extends Thread {
			
			public void run()
			{
				for(int i = 0; i < 4;i ++)
				{
					System.out.println("Removing element " +c1.removeElement()+ " by thead " +Thread.currentThread().getName());

				}
				
			}
		}
		
		testCheck tc = new testCheck();
		Thread t1 = new Thread(tc);
		Thread t2 = new Thread(tc);
		t1.start();
		t2.start();
		
		//System.out.println("--> " +c1.arList);
	}
}

class Check
{
	List<String> arList = Collections.synchronizedList(new ArrayList<>());

	public void addElement(String name)
	{
		arList.add(name);
	}

	public String removeElement()
	{
		if(arList.size() > 0 )
		{
			return arList.remove(0);
		}
		else
		{
			System.out.println("List is empty");
			return null;
		}
	}
}
