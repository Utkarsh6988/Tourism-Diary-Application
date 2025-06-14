
import java.util.concurrent.*;
public class SubmitWithCallable {
public static void main(String[] args) throws Exception {
ExecutorService ex = Executors.newSingleThreadExecutor();
Future<Integer> f = ex.submit(() -> 1 + 2);
System.out.print(f.get());
ex.shutdown();
}
}