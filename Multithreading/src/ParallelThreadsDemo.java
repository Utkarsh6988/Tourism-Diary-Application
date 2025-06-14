//public class ParallelThreadsDemo {
//
//    public static void main(String[] args) {
//        System.out.println("Main thread started - " + Thread.currentThread().getName());
//
//        // Create and start 10 threads
//        for (int i = 0; i < 10; i++) {
//            Thread thread = new Thread(new MyRunnable());
//            thread.start();
//        }
//
//        // Main thread continues its work
//        for (int i = 0; i < 5; i++) {
//            System.out.println("Main thread working - " + Thread.currentThread().getName());
//            try {
//                Thread.sleep(500); // Simulate work
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//
//        System.out.println("Main thread finished - " + Thread.currentThread().getName());
//    }
//
//    static class MyRunnable implements Runnable {
//        @Override
//        public void run() {
//            System.out.println("Thread started - " + Thread.currentThread().getName());
//            try {
//                Thread.sleep(1000); // Simulate work
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println("Thread finished - " + Thread.currentThread().getName());
//        }
//    }
//}

public class ParallelThreadsDemo {

    public static void main(String[] args) {
        System.out.println("Main thread started - " + Thread.currentThread().getName());

        // Create and start 10 threads
        for (int i = 0; i < 10; i++) {
            MyThread thread = new MyThread();
            thread.start();
        }

        // Main thread continues its work
        for (int i = 0; i < 5; i++) {
            System.out.println("Main thread working - " + Thread.currentThread().getName());
            try {
                Thread.sleep(500); // Simulate work
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Main thread finished - " + Thread.currentThread().getName());
    }

    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("Thread started - " + this.getName());
            try {
                Thread.sleep(1000); // Simulate work
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread finished - " + this.getName());
        }
    }
}