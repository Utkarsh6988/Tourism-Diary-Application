import java.util.Random;
import java.util.concurrent.CyclicBarrier;

public class MatrixComputation {
    private static final int SIZE = 1000;
    private static final int THREADS = 4;
    private static final int SUB_SIZE = SIZE / THREADS;
    
    private static double[][] matrix = new double[SIZE][SIZE];
    private static double[] results = new double[SIZE];
    
    public static void main(String[] args) {
        initializeMatrix();
        
        CyclicBarrier barrier = new CyclicBarrier(THREADS, () -> {
            System.out.println("All computations completed. Merging results...");
            // You could add result verification here
            verifyResults();
        });
        
        for (int i = 0; i < THREADS; i++) {
            final int startRow = i * SUB_SIZE;
            final int endRow = (i == THREADS - 1) ? SIZE : startRow + SUB_SIZE;
            
            new Thread(() -> {
                try {
                    for (int row = startRow; row < endRow; row++) {
                        double sum = 0;
                        for (int col = 0; col < SIZE; col++) {
                            sum += matrix[row][col];
                        }
                        results[row] = sum;
                    }
                    
                    System.out.println(Thread.currentThread().getName() + " completed its portion");
                    barrier.await();
                    
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }, "Worker-" + i).start();
        }
    }
    
    private static void initializeMatrix() {
        Random random = new Random();
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                matrix[i][j] = random.nextDouble() * 100;
            }
        }
        System.out.println("Matrix initialized with random values");
    }
    
    private static void verifyResults() {
        // Simple verification that all rows were processed
        for (int i = 0; i < SIZE; i++) {
            if (results[i] == 0) {
                System.out.println("Error: Row " + i + " was not processed");
                return;
            }
        }
        System.out.println("All rows processed successfully");
    }
}