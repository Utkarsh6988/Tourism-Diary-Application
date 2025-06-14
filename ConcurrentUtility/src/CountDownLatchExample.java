import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {
    public static void main(String[] args) throws InterruptedException  {
		  int threadCount=3;
		  CountDownLatch latch = new  CountDownLatch(threadCount);
		  
		  for(int i=0;i<threadCount;i++) {
			  new Thread(()->{
				  System.out.println(Thread.currentThread().getName()+ "working....");
				  try {
					  Thread.sleep(1000);
				  } catch (InterruptedException e) {
					// TODO: handle exception
					  Thread.currentThread().interrupt();
				}
				  latch.countDown();
			  }).start();
		  }
		  
		  latch.await();
		  System.out.println("All Threads Completed!");
	}
}
