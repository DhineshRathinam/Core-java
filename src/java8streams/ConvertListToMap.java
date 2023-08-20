package java8streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

class Student {
	private String studentName;
	private int age;
	private String department;
	private List<Address> addresses;

	public Student(String studentName, int age, String department, List<Address> addresses) {
		this.studentName = studentName;
		this.age = age;
		this.department = department;
		this.addresses = addresses;
	}

	public Student(String studentName, int age, String department) {
		this.studentName = studentName;
		this.age = age;
		this.department = department;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	@Override
	public String toString() {
		return "Student [studentName=" + studentName + ", age=" + age + ", department=" + department + ", addresses="
				+ addresses + "]";
	}

}

class Address {
	private String street;
	private String city;
	private int zipCode;

	public Address(String street, String city, int zipCode) {
		this.street = street;
		this.city = city;
		this.zipCode = zipCode;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	@Override
	public String toString() {
		return "Address [street=" + street + ", city=" + city + ", zipCode=" + zipCode + "]";
	}

}

public class ConvertListToMap {

	public static void main(String[] args) {

		// Using Anonymous Inner class
		/*
		 * Map<String, Integer> map = getStudents().stream().filter(p -> p.getAge() >
		 * 20) .collect(Collectors.toMap(new Function<Student, String>() {
		 * 
		 * @Override public String apply(Student t) { return t.getStudentName(); }
		 * 
		 * }, t -> t.getAge()));
		 */

		Map<String, Integer> mapLambda = getStudents().stream().filter(p -> p.getAge() > 20).collect(Collectors
				.toMap(t -> t.getStudentName(), t -> t.getAge(), (oldValue, newValue) -> oldValue, HashMap::new));

		/*
		 * Map<String, List<Address>> studentWithAddress = getStudents().stream()
		 * .filter(t -> t.getDepartment().equalsIgnoreCase("Electronics"))
		 * .collect(Collectors.toMap(p -> p.getStudentName(), p -> p.getAddresses(), (t,
		 * u) -> t, () -> new HashMap<String, List<Address>>()));
		 * 
		 * System.out.println("studentWithAddress: " + studentWithAddress);
		 */

		// Retrieving the student and their city

		Map<Object, Object> mapLambda1 = getStudents().stream().filter(p -> p.getAge() > 19)
				.collect(Collectors.toMap(p -> p.getStudentName(), student -> {
					List<String> cities = new ArrayList<String>();
					for (Address address : student.getAddresses()) {
						cities.add(address.getCity());
					}
					return cities;
				}, (oldValue, newValue) -> newValue));

		System.out.println(mapLambda1);

		// Retrieving the student and their city - Pass to method

		Map<String, List<String>> mapLambda2 = getStudents().stream().collect(Collectors.toMap(p -> p.getStudentName(),
				p -> getCitiesForStudent(p), (oldValue, newValue) -> oldValue));
		System.out.println("Retrieving the student and their city - Pass to method: " + mapLambda2);

		// Retrieving student name with their address

		Map<String, Object> mapp = getStudents().stream().filter(p -> p.getStudentName().startsWith("aaa")).collect(
				Collectors.toMap(p -> p.getStudentName(), p -> p.getAddresses(), (oldValue, newValue) -> oldValue));
		System.out.println("Retrieving student name with their address - filter: " + mapp);

		// Using flatmap
		List<String> streetList = getStudents().stream().flatMap(p -> p.getAddresses().stream()).map(p -> p.getStreet())
				.collect(Collectors.toList());
		System.out.println(streetList);

		// reduce

		Integer a = getStudents().stream().filter(p -> p.getDepartment().equalsIgnoreCase("Electronics"))
				.map(p -> p.getAge()).reduce(5, new BinaryOperator<Integer>() {

					@Override
					public Integer apply(Integer t, Integer u) {
						return t + u;
					}
				});
		System.out.println(a);

		// reduce with different parameter

		/*
		 * Integer a1 = getStudents().stream().filter(p ->
		 * p.getDepartment().equalsIgnoreCase("Electronics")) .reduce(5, new
		 * BinaryOperator<Student, Student, Student>() {
		 * 
		 * @Override public Student apply(Student t, Student u) { t.getAge()+u.getAge();
		 * } }); System.out.println(a);
		 */

		// min()

		/*
		 * Optional<Student> a1 = getStudents().stream().min(new Comparator<Student>() {
		 * 
		 * @Override public int compare(Student o1, Student o2) { return
		 * o1.getAge()-o2.getAge(); } });
		 */

		// Optional<Student> a1 = getStudents().stream().min((o1, o2) -> o1.getAge() -
		// o2.getAge());

		Optional<Student> a1 = getStudents().stream().max(Comparator.comparing(p -> p.getAge()));

		System.out.println(a1.get().getAge());

		// Object of max age
		Optional<Student> a2 = getStudents().stream().collect(Collectors.minBy(Comparator.comparing(Student::getAge)));
		System.out.println("Object of max age: " + a2.get());

	}

	private static List<String> getCitiesForStudent(Student student) {
		List<String> cities = new ArrayList<String>();
		if (student.getAddresses() != null) {
			for (Address address : student.getAddresses()) {
				cities.add(address.getCity());
			}
		}
		return cities;
	}

	public static List<Student> getStudents() {
		return Arrays.asList(
				new Student("aaa", 20, "Electronics",
						Arrays.asList(new Address("address1", "city1", 111), new Address("address11", "city11", 1111))),
				new Student("bbb", 20, "Electrical",
						Arrays.asList(new Address("address2", "city2", 222), new Address("address22", "city22", 2222))),
				new Student("ccc", 24, "Computer",
						Arrays.asList(new Address("address3", "city3", 333), new Address("address33", "city33", 3333))),
				new Student("ddd", 22, "Electronics",
						Arrays.asList(new Address("address4", "city4", 444), new Address("address44", "city44", 4444))),
				new Student("eee", 19, "Computer",
						Arrays.asList(new Address("address5", "city5", 555), new Address("address55", "city55", 5555))),
				new Student("fff", 21, "Electronics",
						Arrays.asList(new Address("address6", "city6", 666), new Address("address66", "city66", 6666))),
				new Student("fff", 25, "Electronics", Arrays.asList(new Address("address7", "city7", 777),
						new Address("address77", "city77", 7777))));
	}

}
