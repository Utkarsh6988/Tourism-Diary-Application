import static org.junit.jupiter.api.Assertions.*;


import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;

public class TestExample {
  
    @Test 
	public void testAddition() {
    	 assertEquals(7, TestExample.add(2,5));
    	 assertEquals(3, TestExample.add(-2,5));
    	 
    	 assertEquals(0, TestExample.add(0,0));	 
     }
    @Test 
     public void testSubtraction() {
    	 assertEquals(-1, TestExample.subtract(2,3));
    	 assertEquals(-7, TestExample.subtract(-2,5));
    	 assertEquals(0, TestExample.subtract(0,0)); 
     }
    @Test 
     public void testMultiplication() {
    	 assertEquals(6, TestExample.multiply(2,3));
    	 assertEquals(-10, TestExample.multiply(-2,5));
    	 assertEquals(0, TestExample.multiply(0,0));
     }
    @Test 
     public void testDivide() {
    	 assertEquals(1, TestExample.divide(3,3));
    	 assertEquals(2, TestExample.divide(10,5));
    	 assertEquals(3, TestExample.divide(6,2));
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
