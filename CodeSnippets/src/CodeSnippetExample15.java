import java.util.Optional;

public class CodeSnippetExample15 {
	public static void main(String[] args) {

		Optional<String> opt = Optional.of("Test");
		System.out.print(opt.isPresent());

	}
}


//f a value is present, returns true, otherwise false.
//
//Returns:
//true if a value is present, otherwise false