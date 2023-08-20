package charactersandstrings;

public class CharacterCls {

	public static void main(String[] args) {
		System.out.println(Character.isLetter('a'));

		// CompareTo() checks only the contents and erdicates how string is created
		String s1 = "Sachin";
		String s2 = new String("Sachin");
		String s3 = "India is a good country:";
		System.out.println("compareTo: " + s1.compareTo(s2));

		// Converting string to byte[] //getBytes
		byte[] byteArr = s1.getBytes();
		for (byte b : byteArr) {
			System.out.println(b);
		}
		// Converting string to char[] //getChars
		char[] ch = new char[5];
		s1.getChars(0, 2, ch, 0);
		System.out.println(ch);

		System.out.println(s3.isEmpty());

		// replace and replaceall()
		//replace() will replace all character that matches first parameter given in a string 
		//whereas replaceAll() we can provide regular expression like \\s in the first parameter
		//as replacement thing it will not work in replace()

		String s4 = s3.replace("a", "Z");
		System.out.println("replace(): " + s4);

		String s5 = s3.replaceAll("\\s", "good");
		System.out.println("replaceAll(): " + s5);
		Employee employee = new Employee("12345");
		System.out.println(employee.getPancardNumber());
		//employee.pancardNumber = "7838642";
		
		String str = "This is index of example";  
        int index = str.lastIndexOf('s',7);  
        System.out.println("Last index of with range:"+index);   
	}

}

final class Employee {
	final private String pancardNumber;

	public Employee(String pancardNumber) {
		this.pancardNumber = pancardNumber;
	}

	public String getPancardNumber() {
		return pancardNumber;
	}
	
	/*
	 * public void setPancardNumber(String pancardNumber) { this.pancardNumber =
	 * pancardNumber; }
	 */

}