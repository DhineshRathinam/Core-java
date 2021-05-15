package oopsconcepts;

//Refer - https://www.javatpoint.com/exception-handling-with-method-overriding

class Parent {
	public void msg() throws ArithmeticException{
		System.out.println("parent");
	}
}

class TestExceptionChild extends Parent {
	public static final int a = 5;
	
	@Override
	public void msg() throws IndexOutOfBoundsException{
		System.out.println("child "+a);
	}
	
	public void show() {
		System.out.println("Inside the show:");
	}

	public static void main(String args[]) {
		Parent p = new TestExceptionChild();
		p.msg();
		System.out.println(a);
		
	}
}
