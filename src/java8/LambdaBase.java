package java8;

interface MyInterface{
	void show();
}

public class LambdaBase {
	public static void main(String[] args) {
		String a = "plm";
		//Anonymous inner class
		MyInterface myInterface = new MyInterface() {
			@Override
			public void show() {
				System.out.println("Implemented the show method: "+a);
			}
			
		};
		
		//Lambda Expression
		MyInterface myInterfaceLambda = () -> {
			
			System.out.println("Implemented the show method1: "+a);
			
			};
			
		myInterfaceLambda.show();
	}
}
