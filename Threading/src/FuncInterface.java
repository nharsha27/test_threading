
@FunctionalInterface
public interface FuncInterface {

	// an abstract function
	void abstractFun(int x);
	
	// non abstract function
	default void normalFun()
	{
		System.out.println("Hellp");
	}
	

	//int sum = n -> n*n;
	
	
}
