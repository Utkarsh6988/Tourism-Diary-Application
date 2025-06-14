
class MyRunnable implements Runnable {
	private String threadName;

	public MyRunnable(String name) {
		this.threadName = name;
	}

	@Override
	public void run() {
		try {
			for (int i = 0; i <= 5; i++) {
				System.out.println(threadName + ":" + i);
				Thread.sleep(500);
			}
		} catch (InterruptedException e) {
			System.out.println(threadName + "interrupted.");
		}
		System.out.println(threadName + "exiting.");
	}
}

public class RunnableExample {
	public static void main(String[] args) {

		Thread t1 = new Thread(new MyRunnable("Runnable-1"));
		Thread t2 = new Thread(new MyRunnable("Runnable-2"));

		t1.start();
		t2.start();

		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO: handle exception
			System.out.println("Main Thread Interrupted");
		}
		System.out.println("Main Thread Exiting");
	}
}
