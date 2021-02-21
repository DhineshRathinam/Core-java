package collections;

import java.util.Set;
import java.util.TreeSet;

public class Sets {
	public static void main(String[] args) {
		TreeSet<Integer> set = new TreeSet<Integer>();
		set.add(24);
		set.add(66);
		set.add(12);
		set.add(15);
		System.out.println(set.first());

		// retrieves and removes highest
		System.out.println(set.pollLast());

		System.out.println(set.last());

		// Setting comparator sorting for an object for tree set
		Set<Book> set1 = new TreeSet<Book>((o1, o2) -> o1.getAuthor().compareTo(o2.getAuthor()));

		Book b1 = new Book(101, "Let us C", "Yashwant Kanetkar", "BPB", 8);
		Book b2 = new Book(102, "Data Communications and Networking", "Forouzan", "Mc Graw Hill", 4);
		Book b3 = new Book(103, "Operating System", "Galvin", "Wiley", 6);

		set1.add(b1);
		set1.add(b2);
		set1.add(b3);

		System.out.println(set1);

	}

}
