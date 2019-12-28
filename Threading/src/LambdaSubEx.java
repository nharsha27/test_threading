
interface testLambda{
	public abstract void sub(int a, int b);
}

public class LambdaSubEx 
{
	public static void main(String args[])
	{
		testLambda t = (a,b) -> System.out.println("result is: " +(b-a));
		t.sub(2, 5);
		String s1 = "abc";
		String s2 = "xyz";
		s1=s2;
		System.out.println(s1); //xyz
		if(s1 == s1)
		{
			System.out.println("True");
		}
	}
}
