class MyThread extends Thread {
	private String threadName;

	public MyThread(String name) {
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
		System.out.println(threadName + "existing.");
	}
}

public class ThreadExample {
	public static void main(String[] args) {
		MyThread t1 = new MyThread("Thread-1");
		MyThread t2 = new MyThread("Thread-2");

		t1.start();
		t2.start();

//		try {
//			t1.join();  //Join method in Java allows one thread to wait until another thread completes its execution
//			t2.join();
//		} catch (InterruptedException e) {
//			System.out.println("My Thread Interrupted");
//		}
//		System.out.println("Main Thread exiting");
	}
}

//When NOT to Use join()
//When threads are independent and order doesn't matter
//
//In GUI applications where blocking the main thread is undesirable
//
//When using higher-level concurrency utilities (like ExecutorService)
