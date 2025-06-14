import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class CodeSnippetExample12 {
    public static void main(String[] args) {
    	List<String> list = Arrays.asList("apple", "banana", "cherry");
    	Optional<String> opt = list.stream().filter(s -> s.startsWith("b")).findFirst();
    	System.out.print(opt.get());
	}
}
