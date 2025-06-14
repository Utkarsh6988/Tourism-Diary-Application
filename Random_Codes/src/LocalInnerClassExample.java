 // Local inner class, defined inside a method


public class LocalInnerClassExample {   //outer class
	void outerMethod() {
        final int localVar = 40;
        
        // Local inner class
        class LocalInnerClass {
            void display() {
                System.out.println("localVar = " + localVar);
            }
        }
        
        LocalInnerClass localInner = new LocalInnerClass();
        localInner.display();
    }
    
    public static void main(String[] args) {
    	LocalInnerClassExample outer = new LocalInnerClassExample();
        outer.outerMethod();
    }
}