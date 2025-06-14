//NonStaticNestedClassExample or Inner class


public class NonStaticNestedClassExample {

int outerVar = 30;
    
    // Inner class
    class InnerClass {
        void display() {
            System.out.println("outerVar = " + outerVar); // Can access outer class members
        }
    }
    
    public static void main(String[] args) {
    	NonStaticNestedClassExample outer = new NonStaticNestedClassExample();
    	NonStaticNestedClassExample.InnerClass inner = outer.new InnerClass();
        inner.display();
    }
}

