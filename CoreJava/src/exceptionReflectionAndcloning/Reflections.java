package exceptionReflectionAndcloning;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

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
