package oopsconcepts;

//Refer - https://www.javatpoint.com/exception-handling-with-method-overriding

class Parent {
	public void msg() throws ArithmeticException{
		System.out.println("parent");
	}
}

class TestExceptionChild extends Parent {
	@Override
	public void msg() throws IndexOutOfBoundsException{
		System.out.println("child");
	}
	
	public void show() {
		System.out.println("Inside the show:");
	}

	public static void main(String args[]) {
		Parent p = new TestExceptionChild();
		p.msg();
		
	}
}
