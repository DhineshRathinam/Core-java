package oopsconcepts;

import java.util.Arrays;

public class TestArray {
	public static void main(String[] args) {
		double[] myList = { 2.4, 9.3, 1.9, 2.9, 3.4, 3.5 };
		double[] myList1 = { 2.4, 9.3, 1.9, 2.9, 3.4, 3.5 };
		System.out.println(Arrays.equals(myList, myList1));
		Arrays.sort(myList);
		for (int i = 0; i < myList.length; i++) {
			System.out.println(myList[i] + " ");
		}

		System.out.println("Index of search element: " + Arrays.binarySearch(myList, 3.5));

		Arrays.fill(myList, 0, 2, 9.9);

		System.out.println("After fill:");
		for (int i = 0; i < myList.length; i++) {
			System.out.println(myList[i] + " ");
		}

	}
}
