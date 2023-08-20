package exceptionReflectionAndcloning;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * When method throws run time exception and it is called, then exception need
 * not be handled(compiler will not force) in the calling method
 */
public class FilenotFound_Demo {
	public static void main(String args[]) {
		File file = new File("E://file.txt");
		try {
			FileReader fr = new FileReader(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		check();
		System.out.println("Printing: ");
	}

	private static int check() throws NullPointerException {
		String str = null;
		return str.length();
	}
}
