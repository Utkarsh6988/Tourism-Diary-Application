
public class AnonymousInnerClassExample {
	interface Greeting {
        void greet();
    }
    
    void sayHello() {
        // Anonymous inner class implementing Greeting interface
        Greeting greeting = new Greeting() {
            @Override
            public void greet() {
                System.out.println("Hello from anonymous class!");
            }
        };
        greeting.greet();
    }
    
    public static void main(String[] args) {
    	AnonymousInnerClassExample outer = new AnonymousInnerClassExample();
        outer.sayHello();
    }
}