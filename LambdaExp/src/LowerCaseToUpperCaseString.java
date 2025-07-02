import java.util.function.Function;

//public class LowerCaseToUpperCaseString {
//	public static void main(String[] args) {
//
//		Function<String, String> toUpperCase = str -> str.toUpperCase();
//
//		String lowercaseString = "utkarsh arora";
//		String uppercaseString = toUpperCase.apply(lowercaseString);
//
//		System.out.println("Original: " + lowercaseString);
//		System.out.println("Uppercase: " + uppercaseString);
//	}
//}


interface G{
	
	String convert(String s);
}

public class LowerCaseToUpperCaseString {
	public static void main(String[] args) {
	G refG =(x)-> x.toUpperCase();
	System.out.println("Result: "+refG.convert("utkarsh arora"));
}}