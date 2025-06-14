import java.util.Arrays;
import java.util.List;

public class CodeSnippetExample9 {
   public static void main(String[] args) {
	   List<String> list = Arrays.asList("a", "bb", "ccc");
	   long count = list.stream().filter(s -> s.length() == 2).count();
	   System.out.print(count);
}
}
