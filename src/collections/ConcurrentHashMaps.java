package collections;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class ConcurrentHashMaps {
	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, "One");
		map.put(2, "Two");
		map.put(3, "Three");
		map.put(4, "Four");
		map.put(5, "Five");

		iterateEntrySetWithFor(map);

		Map<Integer, String> syncMap = Collections.synchronizedMap(map);
		Map<Integer, String> conMap = new ConcurrentHashMap<Integer, String>(map);

		Iterator<Entry<Integer, String>> it = conMap.entrySet().iterator();
		// Setting up for concurrent modification exception
		while (it.hasNext()) {
			Entry<Integer, String> entry1 = it.next();
			if (entry1.getKey() == 3) {
				conMap.put(6, "Six");
			}
			System.out.println(entry1.getValue());
		}
		conMap.put(6, "Six1");
		System.out.println(conMap);
		Map<Integer, String> map1 = conMap.entrySet().stream().filter(p -> p.getKey() >= 5)
				.collect(Collectors.toConcurrentMap(p -> p.getKey(), p->p.getValue().toUpperCase(), (a, b) -> b));
		System.out.println(map1);
	}

	private static void iterateEntrySetWithFor(Map<Integer, String> map) {
		for (Map.Entry<Integer, String> entry : map.entrySet()) {
			System.out.println("Key: " + entry.getKey() + " , " + "Value: " + entry.getValue());
		}
	}

}
