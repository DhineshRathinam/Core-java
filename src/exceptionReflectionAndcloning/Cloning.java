package exceptionReflectionAndcloning;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Movie implements Cloneable {
	private int id;
	private String name;
	private MovieDetails movieDetails;
	private List<Actor> actors;
	
	public Movie() {
		
	}

	public Movie(int id, String name, MovieDetails movieDetails) {
		this.id = id;
		this.name = name;
		this.movieDetails = movieDetails;
	}

	public Movie(int id, String name, MovieDetails movieDetails, List<Actor> actors) {
		super();
		this.id = id;
		this.name = name;
		this.movieDetails = movieDetails;
		this.actors = actors;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		Movie movie = (Movie) super.clone();
		movie.setMovieDetails((MovieDetails) (movie.getMovieDetails()).clone());
		/*
		 * List<Actor> clonedActor = new ArrayList<Actor>(); for (Actor actor :
		 * movie.getActors()) { clonedActor.add((Actor) movie.getActors()); }
		 * movie.setActors(((List<Actor>) clonedActor).clone());
		 */
		return movie;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public MovieDetails getMovieDetails() {
		return movieDetails;
	}

	public void setMovieDetails(MovieDetails movieDetails) {
		this.movieDetails = movieDetails;
	}

	public List<Actor> getActors() {
		return actors;
	}

	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", name=" + name + ", movieDetails=" + movieDetails + ", actors=" + actors + "]";
	}

}

class MovieDetails implements Cloneable {
	private String producer;
	private String director;

	public MovieDetails(String producer, String director) {
		this.producer = producer;
		this.director = director;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	public String getProducer() {
		return producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	@Override
	public String toString() {
		return "MovieDetails [producer=" + producer + ", director=" + director + "]";
	}

}

class Actor implements Cloneable {
	private String actorName;
	private String role;

	public Actor(String actorName, String role) {
		super();
		this.actorName = actorName;
		this.role = role;
	}

	@Override
	protected Actor clone() throws CloneNotSupportedException {
		return (Actor) super.clone();
	}

	public String getActorName() {
		return actorName;
	}

	public void setActorName(String actorName) {
		this.actorName = actorName;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Actor [actorName=" + actorName + ", role=" + role + "]";
	}

}

public class Cloning {

	public static void main(String[] args) throws CloneNotSupportedException {
		Movie movie = new Movie(1, "Movie1", new MovieDetails("Producer1", "Director1"),
				Arrays.asList(new Actor("Actor1", "Hero"), new Actor("Actor11", "Heroine")));
		System.out.println(movie);
		Movie cloned = (Movie) movie.clone();
		cloned.setName("clonedMovieName");
		cloned.getMovieDetails().setProducer("clonedProducer");
		//Trying to change the actor list from original
	    List<Actor> actors = cloned.getActors().stream().map(p->{
			try {
				return p.clone();
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
			}
			return p;
		}).map(p->{
			p.setActorName(p.getActorName().toUpperCase());
			return p;
		}).collect(Collectors.toList());
	    
		cloned.setActors(actors);
		//Actor cloneActor = (Actor) cloned.getActors().get(0).clone();
		//cloneActor.setActorName("Actor555");
		//cloned.setActors(Arrays.asList(cloneActor));
		System.out.println("Cloned: " + cloned);
		System.out.println("Original: " + movie);
	}

}
