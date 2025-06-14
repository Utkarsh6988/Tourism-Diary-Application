import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableExample {
	public static void main(String[] args) throws Exception {

		ExecutorService ex = Executors.newSingleThreadExecutor(); //ExecutorService is interface,

		Callable<String> task = () -> {
			return "Hello JAVA Full Stack";
		};
		
		Future<String> future = ex.submit(task); //Future is a interface , submit return Future data type
		
		String result = future.get();
		System.out.println(result);
		
		ex.shutdown();
	}
}
