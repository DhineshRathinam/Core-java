package java8;

import java.util.Arrays;
import java.util.List;

public class ForEach {
	
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(18,2,3,4,5);
		numbers.stream().forEach(p->System.out.println(p));
	}

}
