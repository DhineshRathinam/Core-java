package oopsconcepts;

/**
 * 
 * A class can be made static only if it is a nested class. 
 * Nested static class doesn’t need a reference of Outer class. 
 * In this case, a static class cannot access non-static members of the Outer class.
 *
 */
public class NestedExample {
	private String str = "Edureka";
	private static String str1 = "EdurekaStatic";

//Static class
	static class MyNestedClass {
//non-static method
		public void disp() {
			System.out.println(new NestedExample().str);
			System.out.println(str1);
		}
	}

	public static void main(String args[]) {
		NestedExample.MyNestedClass obj = new NestedExample.MyNestedClass();
		obj.disp();

	}
}
