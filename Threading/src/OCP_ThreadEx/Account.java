package OCP_ThreadEx;

public class Account {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Testing");

		Withdraw w1 = new Withdraw(new StringBuilder("A"));
		Withdraw w2 = new Withdraw(new StringBuilder("A"));
		Withdraw w3 = new Withdraw(new StringBuilder("A"));
		Thread t1 =new Thread(w1);
		t1.start();
		Thread t2 = new Thread(w2);
		t2.start();
		Thread t3 = new Thread(w3);
		t3.start();
		
		

	}

}

class Withdraw implements Runnable{

	StringBuilder sb = new StringBuilder();

	Withdraw(StringBuilder sb)
	{
		this.sb = sb;
	}
	public void run()
	{
		for(int i = 0; i < 300;i++)
		{
			synchronized(sb) {
				if(i == 100)
				{
					sb.append("b");
					System.out.println("value of i" +i);
				}
				if(i == 200)
				{
					sb.append("c");
					System.out.println("value of i" +i);
				}
				System.out.println(sb);
			}

		}
	}
}
