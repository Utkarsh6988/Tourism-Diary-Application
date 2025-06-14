
import java.util.*;

public class LambdaExample3 {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("apple", "banana", "pear");
		list.stream().filter(s -> s.startsWith("b")).forEach(System.out::println);
	}
}