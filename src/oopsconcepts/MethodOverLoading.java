package oopsconcepts;

public class MethodOverLoading {

	public int disp(int a, double b) {
		System.out.println("Method A");
		return 9;
	}

	void disp(int a, double b, double c) {
		System.out.println("Method B");
	}

	/*
	 * void disp(int a, float b) { System.out.println("Method C"); }
	 */

	public static void main(String args[]) {
		MethodOverLoading obj = new MethodOverLoading();
		/*
		 * This time promotion won't happen as there is a method with arg list as (int,
		 * float)
		 */
		obj.disp(100, 20.67);
	}

}
