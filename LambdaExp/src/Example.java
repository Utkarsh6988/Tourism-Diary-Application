//Lambda is used with Functional Interface (Interface with only one abstract method )
//Interface only support abstract methods, without using abstract keywords . Therefore interface provides 100% abstraction.

interface A
{
	int calculations(int a , int b);  //Functional Interface 
}
public class Example {
  
	public static void main(String[]args) {
		
		A ref1 = (x,y)-> x+y;  // Making reference of interface    // Two argument Lambda Expression.
		System.out.println("Result="+ref1.calculations(5, 6));		
		
		A ref2 = (x,y)-> x^y;  // Making reference of interface   //Bitwise XOR operation
		System.out.println("Result="+ref2.calculations(5, 6));	
		
		A ref3 = (x,y)-> x<<y;  // Making reference of interface
		System.out.println("Result="+ref3.calculations(6, 3));	
		
		A ref4 = (x,y)-> x>>y;  // Making reference of interface
		System.out.println("Result="+ref4.calculations(6, 1));	
		
	}
}


//For interface we make reference and for class objects.


//Arguments can be multiple more than 2 but expression can only be one 



// Using inbuilt functional interface , not created externally


//import java.util.function.BinaryOperator;
//
//public class Example {
//    public static void main(String[] args) {
//        BinaryOperator<Integer> add = (x, y) -> x + y;
//        System.out.println("Addition: " + add.apply(5, 6)); // 11
//
//        BinaryOperator<Integer> xor = (x, y) -> x ^ y;
//        System.out.println("Bitwise XOR: " + xor.apply(5, 6)); // 3
//
//        BinaryOperator<Integer> leftShift = (x, y) -> x << y;
//        System.out.println("Left Shift: " + leftShift.apply(6, 3)); // 48
//
//        BinaryOperator<Integer> rightShift = (x, y) -> x >> y;
//        System.out.println("Right Shift: " + rightShift.apply(6, 1)); // 3
//    }
//}
