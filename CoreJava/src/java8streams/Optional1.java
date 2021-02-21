package java8streams;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Optional1 {

	public static void main(String[] args) {

		// Using Optional.of(a); will throw null pointer exception, if value is not
		// present in the optional
		String a = null;
		Optional<String> optStr = Optional.ofNullable(a);//Nosuchelement will be thrown, if element is not present
		System.out.println(optStr.orElseGet(() -> "India"));

		Optional<String> b = Optional.of("Good");
		if (b.isPresent()) {
			System.out.println("Present: " + b.get());
		} else {
			System.out.println("Not present:");
		}
		
		Optional<List<Student>> listOfStudents = Optional.ofNullable(ConvertListToMap.getStudents());
		if (listOfStudents.isPresent()) {
			List<Integer> age1 = listOfStudents.get().stream().filter(p -> p.getStudentName().startsWith("fff"))
					.map(Student::getAge).collect(Collectors.toList());
			System.out.println("Res: " + age1);
		}

	}

}
