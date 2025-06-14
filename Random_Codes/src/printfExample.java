
public class printfExample {
   public static void main(String[]args) {
	   String name = "Utkarsh";
	   int age = 23;
	   double height = 1.79;

	   System.out.printf("Name: %s, Age: %d, Height: %.2f meters%n", name, age, height);
	   
	   System.out.println();
	   
	   System.out.printf("|%10s|%n", "Hello");    // Right-aligned in 10-char width
	   System.out.printf("|%-10s|%n", "Hello");   // Left-aligned in 10-char width
	   System.out.printf("|%010d|%n", 123);       // Zero-padded number
   }
}


//Common Format Specifiers
//Specifier	Output Type	Example
//%s	String	"Hello"
//%d	Decimal integer	42
//%f	Floating-point number	3.14159
//%n	Platform line ending	(newline character)
//%b	Boolean	true/false
//%c	Character	'A'
//%t	Date/Time	(various formats)