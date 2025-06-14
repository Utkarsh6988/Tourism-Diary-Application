import java.util.function.Function;

public class CodeSnippetExample5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Function<Integer, Integer> f = x -> x * 2;
		System.out.print(f.apply(5));
	}

}

//@FunctionalInterface
//Represents a function that accepts one argument and produces a result.
//
//This is a functional interface whose functional method is apply(Object).
//
//Type Parameters:
//<T> the type of the input to the function
//<R> the type of the result of the function
