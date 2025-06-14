import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierExample {
    public static void main(String[] args) {
        // Create a CyclicBarrier for 3 threads with an optional barrier action
        CyclicBarrier barrier = new CyclicBarrier(3, () -> {
            System.out.println("All threads have reached the barrier. Continuing...");
        });

        for (int i = 0; i < 3; i++) {
            new Thread(new Worker(barrier, "Thread-" + i)).start();
        }
    }
}

class Worker implements Runnable {
    private final CyclicBarrier barrier;
    private final String name;

    public Worker(CyclicBarrier barrier, String name) {
        this.barrier = barrier;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            System.out.println(name + " is performing its task");
            Thread.sleep((long) (Math.random() * 2000)); // Simulate work
            
            System.out.println(name + " has reached the barrier");
            barrier.await(); // Wait for all threads
            
            System.out.println(name + " is continuing after the barrier");
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}