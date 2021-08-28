package collections;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

class Book1 {
	private int id;
	private String name, author, publisher;
	private int quantity;

	public Book1(int id, String name, String author, String publisher, int quantity) {
		this.id = id;
		this.name = name;
		this.author = author;
		this.publisher = publisher;
		this.quantity = quantity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((publisher == null) ? 0 : publisher.hashCode());
		result = prime * result + quantity;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book1 other = (Book1) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (publisher == null) {
			if (other.publisher != null)
				return false;
		} else if (!publisher.equals(other.publisher))
			return false;
		if (quantity != other.quantity)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Book1 [id=" + id + ", name=" + name + ", author=" + author + ", publisher=" + publisher + ", quantity="
				+ quantity + "]";
	}
}

public class Maps {
	public static void main(String[] args) {
		// Creating map of Books
		Map<Integer, Book> map = new HashMap<Integer, Book>();
		// Creating Books
		Book b1 = new Book(101, "Let us C", "Yashwant Kanetkar", "BPB", 8);
		Book b2 = new Book(102, "Data Communications & Networking", "Forouzan", "Mc Graw Hill", 4);
		Book b3 = new Book(103, "Operating System", "Galvin", "Wiley", 6);
		// Adding Books to map
		map.put(1, b1);
		map.put(2, b2);
		map.put(3, b3);

		System.out.println(map);

		// Replace()

		map.replace(1, new Book(101, "Let us C", "Yashwant Kanetkar", "BPB", 11));

		System.out.println("After replace: " + map);

		map.replaceAll(new BiFunction<Integer, Book, Book>() {

			@Override
			public Book apply(Integer t, Book u) {
				if (u.getQuantity() > 5) {
					return new Book(101, "Let us C", "Yashwant Kanetkar", "BPB", 13);
				}
				return u;
			}
		});
		System.out.println(map);

		// Contains key

		System.out.println("Check for contains key: " + map.containsKey(20));
		System.out.println("Check for contains val: "
				+ map.containsValue(new Book(101, "Let us C", "Yashwant Kanetkar1", "BPB", 13)));

		// Compute

		map.compute(1, new BiFunction<Integer, Book, Book>() {

			@Override
			public Book apply(Integer t, Book u) {
				u.setQuantity(u.getQuantity() + 20);
				return u;
			}
		});

		System.out.println("After compute: " + map);

		map.computeIfAbsent(5, new Function<Integer, Book>() {

			@Override
			public Book apply(Integer t) {
				return new Book(105, "Let us C", "Yashwant Kanetkar1", "BPB", 15);
			}
		});

		System.out.println("After computeIfAbsent: " + map);

		map.computeIfPresent(5, (k, v) -> {
			v.setName(v.getName().toUpperCase());
			return v;
		});

		System.out.println("After computeIfPresent: " + map);
		
		//get and get default
		System.out.println(map.get(1));
		
		LinkedHashMap<Integer, Book> lhm = new LinkedHashMap<Integer, Book>();
		
	}

}
