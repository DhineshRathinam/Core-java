package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.UnaryOperator;

class Book {
	private int id;
	private String name, author, publisher;
	private int quantity;

	public Book(int id, String name, String author, String publisher, int quantity) {
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
		Book other = (Book) obj;
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
		return "Book [id=" + id + ", name=" + name + ", author=" + author + ", publisher=" + publisher + ", quantity="
				+ quantity + "]";
	}

}

public class ArrayLists {

	public static void main(String[] args) {

		Book b1 = new Book(101, "Let us C", "Yashwant Kanetkar", "BPB", 8);
		Book b2 = new Book(102, "Data Communications and Networking", "Forouzan", "Mc Graw Hill", 4);
		Book b3 = new Book(103, "Operating System", "Galvin", "Wiley", 6);

		List<Book> books = new ArrayList<Book>();
		books.add(b1);
		books.add(b2);
		books.add(b3);

		System.out.println("Initial: "+books);
		books.add(1, new Book(104, "Operating System1", "Galvin1", "Wiley1", 9));

		System.out.println("add at index pos: " + books);

		List<Book> books1 = Arrays.asList(new Book(111, "Book111", "Author111", "Pub111", 11),
				new Book(112, "Book112", "Author112", "Pub112", 12),
				new Book(103, "Operating System", "Galvin", "Wiley", 6));
		
		books.addAll(books1);
		//Object Sorting
		Collections.sort(books, new Comparator<Book>() {

			@Override
			public int compare(Book o1, Book o2) {
				return o1.getId()>o2.getId()?1: (o1.getId() < o2.getId() ? -1 : 0);
			}

		});
		
		System.out.println("AfterSorting: "+books);
		
		//Contains - Internally checks equals method
		boolean isContains = books.contains(new Book(103, "Operating System", "Galvin", "Wiley", 69));
		System.out.println("Contains() : "+isContains);
		
		//Remove - index
		books.remove(1);
		System.out.println("remove with index: "+books);
		
		//Remove with object
		books.remove(new Book(102, "Data Communications and Networking", "Forouzan", "Mc Graw Hill", 4));
		System.out.println("Remove with object: "+books);
		
		//retainAll - Intersection
		
		books.retainAll(books1);
		System.out.println(books);
		
		//indexOf
		
		int a = books.indexOf(new Book(103, "Operating System", "Galvin", "Wiley", 6));
		System.out.println("Indexof: "+a);
		
		//removeAll
		
		/*
		 * books.removeAll(books1); System.out.println(books);
		 */
		
		//removeIf
		
		books.removeIf(p->p.getId() == 103);
		System.out.println(books);
		books.add(new Book(103, "Operating System", "Galvin", "Wiley", 6));
		System.out.println(books);
		books.set(0, new Book(150, "Operating System", "Galvin", "Wiley", 6));
		System.out.println(books);
		
		//ReplaceAll
		
		books.replaceAll(new UnaryOperator<Book>() {
			
			@Override
			public Book apply(Book t) {
				t.setName(t.getName().toUpperCase());
				return t;
			}
		});
		
		System.out.println("ReplaceAll: "+books);
	}
}
