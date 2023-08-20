package java8;

interface A{
	public abstract void show();
	
	static int addition(int a, int b) {
		return a+b;
	}
	
	default int difference(int a, int b) {
		return a-b;
	}
}

public class DefaultAndStaticMethods {
	
	public static void main(String[] args) {
		System.out.println(A.addition(1, 9));
		
		A a = new A() {
			
			@Override
			public void show() {
				System.out.println("Inside the show method:");
				
			}
		};
		
		System.out.println(a.difference(9, 8));
	}

}
