package exceptionReflectionAndcloning;

/**
 * If catch block is not present after try then it behaves like normal flow gets distrubed
 * 
 * Inside the finally block: 
	Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 3
	at exceptionReflectionAndcloning.ExcepTest.main(ExcepTest.java:8)
 *
 */
public class ExcepTest {

   public static void main(String args[]) {
      try {
         int a[] = new int[2];
         System.out.println("Access element three :" + a[3]);
		} /*
			 * catch (ArrayIndexOutOfBoundsException e) {
			 * System.out.println("Exception thrown  :" + e); }
			 */ finally {
    	  System.out.println("Inside the finally block: ");
      }
      System.out.println("Out of the block");
   }
}
