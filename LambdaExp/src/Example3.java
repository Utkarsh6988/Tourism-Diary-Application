
interface Greeting {
    void greet(String name);  // Single-parameter abstract method
}

public class Example3 {
    public static void main(String[] args) {
        // Lambda expression with single argument (name)
        Greeting greetUser = (name) -> {
            System.out.println("Hello, " + name + "!");
        };

        // Calling the method
        greetUser.greet("Alice");  
        greetUser.greet("Bob");    // Output: Hello, Bob!
    }
}