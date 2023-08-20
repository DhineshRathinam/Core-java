package oopsconcepts;

class Animal {
	public int a = 9;
	public static int b = 7;
	
	   public void move() {
	      System.out.println("Animals can move: "+a);
	      System.out.println("Animals can move static: "+b);
	   }
	   
	   public void move1() {
		      System.out.println("Animals can move1");
		   }
	   public static void show() {
		   System.out.println(new Animal().a);
		   System.out.println(b);
	   }
	}

	class Dog extends Animal {
	   public void move() {
	      System.out.println("Dogs can walk and run");
	   }
	   
	   public void move2() {
		      System.out.println("Dogs can walk and run 2");
		   }
	}

	public class TestDog {

	   public static void main(String args[]) {
	      Animal a = new Animal();   // Animal reference and object
	      Animal b = new Dog();   // Animal reference but Dog object

	      a.move();   // runs the method in Animal class
	      b.move();   // runs the method in Dog class
	      Animal.show();
	   }
	}
