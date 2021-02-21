package exceptionReflectionAndcloning;

public class ObjectCreation {
	
	public static void main(String[] args) {
		try {
			Class cls = Class.forName("exceptionReflectionAndcloning.Movie");
			Movie movie = (Movie) cls.newInstance();
			movie.setName("MovieName");
			System.out.println(movie.getName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}

}
