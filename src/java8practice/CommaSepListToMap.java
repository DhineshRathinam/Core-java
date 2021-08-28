package java8practice;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CommaSepListToMap {
	public static void main(String[] args) {
		List<String> l1 = Arrays.asList("11,21", "12,21", "13,23", "13,24");
		Map<Object, Object> map = l1.stream()
				.collect(Collectors.toMap(p -> split(p, 'k'), p -> split(p, 'v'), (a, b) -> b));
		System.out.println(map);
	}

	public static String split(String input, char identifier) {
		String[] s1 = input.split(",");
		return (identifier == 'k') ? s1[0] : s1[1];
	}

}
