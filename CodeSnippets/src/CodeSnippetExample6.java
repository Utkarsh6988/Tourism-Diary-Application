import java.util.function.Supplier;

public class CodeSnippetExample6 {
    public static void main(String[] args) {
		
    	Supplier<String> sup = () -> "Java";
    	System.out.print(sup.get());
	}
}

//@FunctionalInterface
//Represents a supplier of results.
//
//There is no requirement that a new or distinct result be returned each time the supplier is invoked.
//
//This is a functional interface whose functional method is get().
//
//Type Parameters:
//<T> the type of results supplied by this supplier