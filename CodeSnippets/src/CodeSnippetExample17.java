import java.util.Optional;

public class CodeSnippetExample17 {
      public static void main(String[] args) {
		
    	  Optional<String> opt = Optional.of("Hello");
    	  opt.ifPresent(s -> System.out.print(s.toUpperCase()));


	}
}
