import java.util.function.Predicate;

public class CodeSnippetExample7 {
    public static void main(String[] args) {
		
    	Predicate<String> p = s -> s.length() > 3;
    	System.out.print(p.test("Hi") + " " + p.test("Hello"));

	}
}

//@FunctionalInterface
//Represents a predicate (boolean-valued function) of one argument.
//
//This is a functional interface whose functional method is test(Object).
//
//Type Parameters:
//<T> the type of the input to the predicate