


interface funcInterface123{
	public void m1();
}

public class FuncLambda {

	public static void main(String[] args) {

//		ImplFuncInterface iFun = new ImplFuncInterface();
//		iFun.m1();
		// parent class can hold child object
		//funcInterface123 iFunc = new ImplFuncInterface();
		//iFunc.m1();
		
		funcInterface123 iFunc = () -> System.out.println("I am in m1");
		iFunc.m1();
	}

}
