
 interface interf
{
 public abstract void square(int a);	
}
 
 class testing implements interf{

	@Override
	public void square(int a) {	
		System.out.println("sum is: " +(a*a));
	}
 }

public class TestingLambdaSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		interf f = a -> System.out.println("sum is: " +(a*a));
	 f.square(2);
	 
		
		
	}
}
