import java.util.Arrays;
import java.util.List;

public class CodeSnippetExample4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
          
		List<String> list = Arrays.asList("A", "B", "C");
		list.forEach(s -> System.out.print(s.toLowerCase() + " "));
	}

}
