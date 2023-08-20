package java8Files;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.stream.Stream;

public class Files1 {
	
	/**
	 * 1 and 3 efficient, whereas 2 is not.
	 * 
	 * 1. Files.lines() -> returns Stream<String>
	 * 2. Files.readAllLines() -> returns List<String>
	 * 3. BufferedReader br = Files.newBufferedReader(Paths.get("bookIndex.txt"));
	 * 	  Stream<String> lines = br.lines();
	 * 
	 * 4. Files.list() -> returns Stream<Path>
	 * Can use either 5 or 6
	 * 5. Files.walk() -> returns Stream<Path>
	 * 6. Files.find() -> returns Stream<Path>
	 */

	public static void main(String[] args) {
		try {
			Stream<String> lines = Files.lines(Paths.get("F:\\input.txt"), StandardCharsets.UTF_8);
			String a = "India";

			 Files.write(Paths.get("F:\\input.txt"), a.getBytes(),
			StandardOpenOption.APPEND);

			lines.filter(p -> p.startsWith("Anne")).map(p -> p.toUpperCase()).forEach(System.out::println);

			//Stream<Path> paths = Files.list(Paths.get("F:\\Angular\\angularPractice"));
			//paths.filter(p -> Files.isDirectory(p)).forEach(System.out::println);
			
			int depth = Integer.MAX_VALUE;
			try (Stream<Path> paths1 = Files.find(
			    Paths.get("F:\\VSCode-win32-x64-1.53.2"), 
			    depth, 
			    (path, attr) -> {
			      return attr.isRegularFile() && path.toString().endsWith(".dll");  
			    })) {
			  paths1.forEach(System.out::println);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
