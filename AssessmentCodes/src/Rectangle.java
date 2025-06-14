
import java.util.*;
public class Rectangle {
  
	public static double area(double length,double breadth) {
		return length*breadth;
	}
	
	public static double area(double side) {
		return side*side;
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Length and breadth");
		double l = sc.nextDouble();
		double b = sc.nextDouble();
		
		System.out.println("Enter a side of square");
		double s = sc.nextDouble();
		
		System.out.println("Area of rectangle:"+area(l,b));
		System.out.println("Area of square:"+area(s));
		
		
		sc.close();
	}
}
