// Static nested class example

public class OuterClass {
    static int outerStaticVar = 10;
    int outerInstanceVar = 20;
    
 // Static nested class
    static class StaticNestedClass {
        void display() {
            System.out.println("outerStaticVar = " + outerStaticVar);
            // Cannot access outerInstanceVar directly here
        }
    }
    
    public static void main(String[] args) {
        // Create instance of static nested class
        OuterClass.StaticNestedClass nested = new OuterClass.StaticNestedClass();
        nested.display();
    }
}