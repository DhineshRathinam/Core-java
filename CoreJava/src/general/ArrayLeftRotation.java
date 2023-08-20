package general;

import java.util.ArrayList;
import java.util.List;

public class ArrayLeftRotation {
	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4, 5 };
		int d = 4;
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		// rot on list
		System.out.println("Rotation from list: " + rotLeftList(list, d));
		// rot on arr
		int[] resArr = rotLeftArr(a, d);
		for (int i = 0; i < resArr.length; i++) {
			System.out.println(resArr[i]);

		}
	}

	public static List<Integer> rotLeftList(List<Integer> a, int d) {
		for (int i = 0; i < d; i++) {
			int temp = a.get(0);
			for (int j = 1; j < a.size(); j++) {
				a.set(j - 1, a.get(j));
			}
			a.set(a.size() - 1, temp);
		}
		return a;
	}

	public static int[] rotLeftArr(int[] a, int d) {
		for (int i = 0; i < d; i++) {
			int temp = a[0];
			for (int j = 1; j < a.length; j++) {
				a[j - 1] = a[j];
			}
			a[a.length - 1] = temp;
		}
		return a;
	}
}
