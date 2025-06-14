
import java.util.function.Function;

public class LambdaExample {
	public static void main(String[] args) {
		Function<String, Integer> length = s -> s.length();
		System.out.println(length.apply("hello"));
	}
}