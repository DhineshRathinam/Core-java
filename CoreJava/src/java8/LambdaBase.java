package java8;

interface MyInterface{
	void show();
}

public class LambdaBase {
	public static void main(String[] args) {
		//Anonymous inner class
		MyInterface myInterface = new MyInterface() {
			@Override
			public void show() {
				System.out.println("Implemented the show method:");
			}
			
		};
		
		//Lambda Expression
		MyInterface myInterfaceLambda = () -> System.out.println("Implemented the show method:");
			
		myInterfaceLambda.show();
	}
}
