package multithreading;

public class TestSleepMethod1 implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(i);
		}
	}

	public static void main(String[] args) {
		Thread t1 = new Thread(new TestSleepMethod1());
		Thread t2 = new Thread(new TestSleepMethod1());

		t1.start();
		t2.start();
	}

}
