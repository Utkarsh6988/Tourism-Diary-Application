//CountDownLatch problem


import java.util.concurrent.*;
public class CountDownLatchProblem {
public static void main(String[] args) throws InterruptedException {
CountDownLatch latch = new CountDownLatch(1);
new Thread(() -> { System.out.print("A "); latch.countDown(); }).start();
latch.await();
System.out.print("B ");
}
}
