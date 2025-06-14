import java.util.Optional;

public class CodeSnippetExample16 {
   public static void main(String[] args) {
	
	   Optional<String> opt = Optional.empty();
	   System.out.print(opt.orElse("Default"));
	   
	   System.out.println();
	   
	   Optional<String> opt1 = Optional.of("Test");
	   System.out.print(opt1.orElse("Default"));
	   
	   System.out.println();
	   
	   Optional<String> opt2 = Optional.ofNullable(null);
	   System.out.print(opt2.isPresent());
}
}
