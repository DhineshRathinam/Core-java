package collections;

//Java code to illustrate the equals() method
import java.util.*;

public class Map_Demo {
	public static void main(String[] args)
	{
		// Creating an empty Map
		Map<Integer, String> map1 = new HashMap<Integer, String>();
		Map<Integer, String> map2 = new HashMap<Integer, String>();

		// Mapping string values to int keys
		map1.put(10, "Geeks");
		map1.put(15, "4");
		map1.put(20, "Geeks");
		map1.put(25, "Welcomes");
		map1.put(30, "You");

		// Mapping string values to int keys
		map2.put(10, "Geeks");
		map2.put(15, "4");
		map2.put(20, "Geeks");
		map2.put(25, "Welcomes");
		map2.put(30, "You");

		// Displaying the Map1
		System.out.println("First Map: "
						+ map1);

		// Displaying the Map2
		System.out.println("Second Map: "
						+ map2);

		// Checking the equality
		System.out.println("Equality: " + map1.equals(map2));
		
		Map<Post, Integer> hmap = new HashMap<Post, Integer>();
		hmap.put(new Post(1, "post1", "info2"), 1);
		hmap.put(new Post(1, "post1", "info2"), 2);
		
		System.out.println(hmap);
	}
}

