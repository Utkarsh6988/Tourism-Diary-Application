import java.util.Arrays;
import java.util.List;

public class CodeSnippetExample11 {
    public static void main(String[] args) {
    	List<Integer> list = Arrays.asList(4, 5, 6);
    	list.stream().map(i -> i * i).forEach(i -> System.out.print(i + " "));
	}
}
