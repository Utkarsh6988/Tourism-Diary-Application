import java.util.Arrays;
import java.util.List;

public class CodeSnippetExample13 {
    public static void main(String[] args) {
    	List<Integer> list = Arrays.asList(1, 2, 3, 4);
    	int max = list.stream().max(Integer::compare).get();
    	System.out.print(max);

	}
}
