package exceptionReflectionAndcloning;

import java.lang.reflect.Constructor;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


/**
 * Reflection is an API which is used to examine or modify the behavior of methods, classes, interfaces at runtime.

- The required classes for reflection are provided under java.lang.reflect package.

- Reflection gives us information about the class to which an object belongs and also the methods 
	of that class which can be executed by using the object.
	
- Through reflection we can invoke methods at runtime irrespective of the access specifier used with them.

 *
 */

class Test { 
	private String a;

	public Test() {

	}

	public Test(String a) {
		this.a = a;
	}

	public String getA() {
		return a;
	}

	public void setA(String a) {
		this.a = a;
	}

	private int add(int a, int b) {
		return a + b;
	}

}

public class Reflections {

	public static void main(String[] args) {
		Test test = new Test();
		Class<Test> cls = (Class<Test>)test.getClass();
		System.out.println(cls.getName());

		Constructor[] constructor = cls.getConstructors();

		for (Constructor constructor2 : constructor) {
			System.out.println(constructor2.getName());
		}

		Method[] methods = cls.getDeclaredMethods();

		for (Method method : methods) {
			System.out.println(method.getName());
		}

		try {
			Method decMethod = cls.getDeclaredMethod("add", int.class, int.class);
			decMethod.setAccessible(true);
			int res = (int) decMethod.invoke(test, 20, 100);
			System.out.println(res);
		} catch (NoSuchMethodException | SecurityException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			//Run time exception
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Field field = cls.getDeclaredField("a");
			field.setAccessible(true);

			field.set(test, "JAVA");
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(test.getA());

		System.out.println(cls.isInterface());
	}

}
