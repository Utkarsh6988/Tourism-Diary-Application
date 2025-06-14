import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CodeSnippetExample14 {
       public static void main(String[] args) {
		
    	   List<String> list = Arrays.asList("A", "B", "C");
    	   String joined = list.stream().collect(Collectors.joining(","));
    	   System.out.print(joined);
	}
}
