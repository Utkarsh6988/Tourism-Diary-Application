import java.util.concurrent.*; // java concurrency API

// ExecutorService Interface manages thread and task execution

class Service implements Runnable
{
	public void run()
	{
		System.out.println("Thread Name:"+Thread.currentThread().getName());
	}
}


public class ConcurrentUtility {
	public static void main(String args[]) throws Exception
	{
		ExecutorService ex=Executors.newFixedThreadPool(5);// Total thread count =5, ExecutorService creates a thread pool of 5 threads
		for(int i=0;i<50;i++)
		{
			ex.execute(new Service());// submit 50 tasks, execute has no return data type does not return anything
		}
		System.out.println("Thread Name:"+Thread.currentThread().getName());
		ex.shutdown();// shutdown ExecutorService
	}
	
	
}