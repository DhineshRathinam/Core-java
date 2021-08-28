package java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ForEach {
	
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(18,2,3,4,5);
		//numbers.stream().forEach(t -> System.out.println(t));
		//sorted() is stateful method so it should not use along with parallel streams. It will results in unordered. 
		//Any execution which depends on any of the prev execution results then use of parallel operation should be avoided
		numbers.stream().parallel().sorted().forEachOrdered(p->System.out.println(p));
		
		Consumer<Integer> consumer = p->process(p);
		Consumer<Integer> consumer1 = p->System.out.println(p);
		consumer.andThen(consumer1).accept(5);
	}
	
	private static void process(Integer a) {
		System.out.println(a*3);
	}

}
