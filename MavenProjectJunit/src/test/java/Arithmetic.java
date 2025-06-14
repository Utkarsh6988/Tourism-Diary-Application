
import static org.junit.jupiter.api.Assertions.*;
//import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class Arithmetic {
  
    @Test 
	public void testAddition() {
    	 assertEquals(7, Arithmetic.add(2,5));
    	 assertEquals(3, Arithmetic.add(-2,5));
    	 
    	 assertEquals(0, Arithmetic.add(0,0));	 
     }
    @Test 
     public void testSubtraction() {
    	 assertEquals(-1, Arithmetic.subtract(2,3));
    	 assertEquals(-7, Arithmetic.subtract(-2,5));
    	 assertEquals(0, Arithmetic.subtract(0,0)); 
     }
    @Test 
     public void testMultiplication() {
    	 assertEquals(6, Arithmetic.multiply(2,3));
    	 assertEquals(-10, Arithmetic.multiply(-2,5));
    	 assertEquals(0, Arithmetic.multiply(0,0));
     }
    @Test 
     public void testDivide() {
    	 assertEquals(1, Arithmetic.divide(3,3));
    	 assertEquals(2, Arithmetic.divide(10,5));
    	 assertEquals(3, Arithmetic.divide(6,2));
     }
     
     public static int add(int a, int b) {
    	 return a+b;
     }
     public static int subtract(int a, int b) {
    	 return a-b;
     }
     public static int multiply(int a, int b) {
    	 return a*b;
     }
     public static int divide(int a, int b) {
    	 return a/b;
     }

}
