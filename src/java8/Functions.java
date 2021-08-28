package java8;

import java.util.function.Function;

/*andThen()

-- Consumer - accepts input and returns void; by doing andThen(consumer) two separate task will be done - both will be independent to each other

-- function - by doing andThen(function) o/p of one task will be given as the input of other because function return values
*/
public class Functions {
	public static void main(String[] args) {

		Function<Integer, Integer> f1 = num -> (num - 4);
		Function<Integer, Integer> f2 = num -> (num * 2);
		
		int c = f1.apply(10);
		System.out.println("Normal way: "+f2.apply(c));

		// Using andThen() method
		int a = f1.andThen(f2).apply(10);
		System.out.println(a);// Output - 12

		// Using compose function
		int b = f1.compose(f2).compose(f1).apply(10);
		System.out.println(b);// Output - 16
	}
}
