import java.util.Arrays;
import java.util.List;

public class CodeSnippetExample8 {
    public static void main(String[] args) {
		
    	List<Integer> list = Arrays.asList(1, 2, 3);
    	int sum = list.stream().mapToInt(i -> i).sum();
    	System.out.print(sum);
	}
}
