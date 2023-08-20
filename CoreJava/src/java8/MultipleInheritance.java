package java8;


/*
1. Static method inside the interface has to be called with class Name.method name in the implementing class.

2. Default method is duplicated in the implementing class then compiler will force for the overriding the default 
method and provide the own implementation or choose which default method inside which interface needs to be called
*/

interface A1{
	public abstract void show();
	
	static int addition(int a, int b) {
		return a+b;
	}
	
	default int difference(int a, int b) {
		return a-b;
	}
}

interface B{
	public abstract void show();
	
	static int addition(int a, int b) {
		return a+b;
	}
	
	default int difference(int a, int b) {
		return a-b-9;
	}
}

public class MultipleInheritance implements A1,B{

	@Override
	public void show() {
		System.out.println("Inside show method:");
		
	}

	
	@Override
	public int difference(int a, int b) {
		return A1.super.difference(a, b);
	}


	public static void main(String[] args) {
		MultipleInheritance multipleInheritance = new MultipleInheritance();
		multipleInheritance.show();
		System.out.println(multipleInheritance.difference(100, 70));
		System.out.println(A1.addition(100, 70));
	}

}
