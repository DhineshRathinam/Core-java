package java8streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class GroupingBy {

	public static void main(String[] args) {
		// Grouping the items alone

		Map<String, Set<Student>> map = ConvertListToMap.getStudents().stream()
				.collect(Collectors.groupingBy(p -> p.getDepartment(), Collectors.toSet()));

		System.out.println("Grouping the items alone: " + map);

		// Grouping and counting items in the group

		Map<Object, Long> map1 = ConvertListToMap.getStudents().stream()
				.collect(Collectors.groupingBy(p -> p.getDepartment(), Collectors.counting()));
		System.out.println("Grouping and counting items in the group: " + map1);

		// Grouping and calculating an avg per grp

		Map<Object, Double> map2 = ConvertListToMap.getStudents().stream()
				.collect(Collectors.groupingBy(p -> p.getDepartment(), Collectors.averagingInt(p -> p.getAge())));
		System.out.println("Grouping and calculating an avg per grp: " + map2);

		// Grouping and calculating statistical summary per grp

		Map<Object, IntSummaryStatistics> map3 = ConvertListToMap.getStudents().stream()
				.collect(Collectors.groupingBy(p -> p.getDepartment(), Collectors.summarizingInt(p -> p.getAge())));

		System.out.println("Grouping and calculating statistical summary per grp: " + map3);

		// Grouping after doing mapping

		Map<String, List<Object>> map4 = ConvertListToMap.getStudents().stream().collect(Collectors
				.groupingBy(p -> p.getDepartment(), Collectors.mapping(p -> p.getStudentName(), Collectors.toList())));
		System.out.println("Grouping after doing mapping: " + map4);

		// Grouping after doing reducing
		// collectors.reducing - 0, Student::getAge, Integer::max

		Map<Object, Integer> map5 = ConvertListToMap.getStudents().stream().collect(Collectors.groupingBy(
				p -> p.getDepartment(), Collectors.reducing(0, p -> p.getAge(), new BinaryOperator<Integer>() {

					@Override
					public Integer apply(Integer t, Integer u) {
						return t + u;
					}
				})));
		System.out.println("Grouping after doing reducing: " + map5);

		// Grouping and getting min/max by per grp

		Map<Object, Optional<Student>> res = ConvertListToMap.getStudents().stream().collect(
				Collectors.groupingBy(p -> p.getDepartment(), Collectors.minBy(Comparator.comparing(Student::getAge))));
		System.out.println("Grouping and getting min/max by per grp: " + res);

		// Nested grouping
		List<Student> nestedList = Arrays.asList(
				new Student("ggg", 19, "Computer", Arrays.asList(new Address("address7", "city7", 777))),
				new Student("hhh", 19, "Computer", Arrays.asList(new Address("address8", "city8", 888))),
				new Student("iii", 19, "Computer", Arrays.asList(new Address("address9", "city9", 999))),
				new Student("jjj", 21, "Electronics", Arrays.asList(new Address("address10", "city10", 101010))),
				new Student("kkk", 21, "Computer", Arrays.asList(new Address("address7", "city7", 777))));

		Map<String, Map<Integer, List<Student>>> nestedGrouping = nestedList.stream()
				.collect(Collectors.groupingBy(p -> p.getDepartment(), Collectors.groupingBy(Student::getAge)));
		System.out.println("Nested grouping: " + nestedGrouping);
	}

}
