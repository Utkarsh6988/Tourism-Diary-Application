import java.util.stream.Stream;

public class CodeSnippetExample10 {
       public static void main(String[] args) {
		
    	   Stream.of("x", "y", "z").forEach(s -> System.out.print(s + " "));
	}
}
