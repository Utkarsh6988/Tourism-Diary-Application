
import java.util.concurrent.*;
public class FixedThreadPool{
public static void main(String[] args) {
ExecutorService ex = Executors.newFixedThreadPool(2);
ex.execute(() -> System.out.print("1 "));
ex.execute(() -> System.out.print("2 "));
ex.shutdown();
}
}
