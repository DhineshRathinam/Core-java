package collections;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteCollections {

	public static void main(String[] args) {
		CopyOnWriteArrayList<Integer> numbers = new CopyOnWriteArrayList<>(new Integer[] { 1, 3, 5, 8 });

		for (Integer number : numbers) {
			if (number == 3) {
				numbers.add(11);
				numbers.remove(3);
			}
			System.out.println(number);
		}

		System.out.println(numbers);
		// Iterator.remove is not allowed, throws UnsupportedOperationException
		Iterator<Integer> iterator = numbers.iterator();
		while (iterator.hasNext()) {
			Integer a = iterator.next();
			System.out.println(a);
			if (a == 3) {
				iterator.remove();
			}
		}
	}
}
