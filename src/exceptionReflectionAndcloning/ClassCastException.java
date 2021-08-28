package exceptionReflectionAndcloning;

/**
 * 
 * 1. When we try to cast an object of Parent class to its Child class type, this
 * exception will be thrown. 
 * 
 * 2. When we try to cast an object of one class into
 * another class type that has not extended the other class or they don't have
 * any relationship between them.
 *
 */

class ParentTest {
	String parentName;

	ParentTest(String n1) {
		parentName = n1;
	}

	public void display() {
		System.out.println("Parent");
	}
}

class ChildTest extends ParentTest {
	String childName;

	ChildTest(String n2) {
		super(n2);
		childName = n2;
	}

	public void display() {
		// super.display();
		System.out.println(childName);
	}
}

public class ClassCastException {
	public static void main(String args[]) {
		ParentTest ct1 = new ChildTest("Jai");
		// ParentTest pt1 = new ParentTest("Adithya");
		// pt1 = ct1;
		ct1.display();

		ParentTest pt2 = new ParentTest("Sai");
		ChildTest ct2 = (ChildTest) pt2;
	}
}
