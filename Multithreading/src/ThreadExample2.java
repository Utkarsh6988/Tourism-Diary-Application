class A extends Thread{
	
	private String threadName;

	public A(String name) {
		this.threadName = name;
	}
	@Override
	public void run() {
		try {
		for(int i=0;i<=5;i++) {
			System.out.println(threadName+":"+i);
			Thread.sleep(2000); // 2 second , so 5 times loop executes so total 10 seconds to execute whole output
		}} catch(InterruptedException e) {
			System.out.println(threadName + "Interrupted");
		}
		System.out.println(threadName+"Exiting");
	}
}


public class ThreadExample2 {
      public static void main(String[] args) {
		A t1 = new A("Thread Utkarsh");
		A t2 = new A("Thread Mahi");
		A t3 = new A("Thread Adi");
		
		
		t2.start();
		t3.start();
		try {
			t2.join();
			t3.join();
		} catch (InterruptedException e) {
			System.out.println("Main Thread Interrupted");
		}
		
		t1.start();
		
		
		
		
	}
}
