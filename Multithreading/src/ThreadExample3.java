
public class ThreadExample3 {
    public static void main(String[] args) {
        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(10000); // Wait for 10 seconds
                    System.out.println("harsh");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    break;
                }
            }
        }).start();
        
        // Keep main thread alive
        try {
            Thread.sleep(60000); // Run for 1 minute
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
