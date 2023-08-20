package collections;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

class Post {
	private int id;
	private String name;
	private String info;
	
	public Post(int id, String name, String info) {
		this.id = id;
		this.name = name;
		this.info = info;
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

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		//result = prime * result + ((info == null) ? 0 : info.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Post other = (Post) obj;
		if (id != other.id)
			return false;
		/*
		 * if (info == null) { if (other.info != null) return false; } else if
		 * (!info.equals(other.info)) return false;
		 */
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", name=" + name + ", info=" + info + "]";
	}

}

public class Sets {
	public static void main(String[] args) {
		TreeSet<Integer> set = new TreeSet<Integer>();
		set.add(24);
		set.add(66);
		set.add(12);
		set.add(15);

		System.out.println(set.headSet(15, true));

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
		
		Set<Post> hset = new HashSet<Post>();
		hset.add(new Post(1, "post1", "info2"));
		hset.add(new Post(1, "post1", "info1"));
		
		
		Set<Post> hset1 = new HashSet<Post>();
		hset1.add(new Post(1, "post1", "info2"));
		hset1.add(new Post(1, "post1", "info3"));
		
		System.out.println("Set val: "+hset);
		System.out.println(hset.equals(hset1));

	}

}
