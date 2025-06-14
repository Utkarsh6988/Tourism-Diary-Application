//Synchronization in Java ensures that only one thread can access a shared resource at a time, this is called mutual exclusion
//preventing race conditions and data inconsistency in multithreaded environments.

//Use synchronized method to ensure thread synchronization
class Show
{
	public synchronized void show(int n ) //mutual exclusion is ensure
	{
		for (int i=0;i<5;i++)
		{
			System.out.println(n*i);
		}
	}
}

class First extends Thread
{
	Show s;
	First(Show s)
	{
		this.s=s;
	}

	public void run()
	{
		s.show(4);
	}
	
}

class Second extends Thread
{
	Show s;
	Second(Show s)
	{
		this.s=s;
	}

	public void run()
	{
		s.show(6);
	}
	
}

public class  SynchronizationExample {
	
	public static void main(String[] args) throws InterruptedException
	{
		
		Show s=new Show();
		First t1=new First(s);
	    Second t2=new Second(s);
		t1.start();
		t2.start();
	}

}