import java.util.Optional;

public class OptionalExamples {
    
    // Sample method that might return null
    private static String findUserById(int id) {
        if (id == 123) {
            return "john.doe@example.com";
        }
        return null;  // Simulating "not found"
    }
    
    // Method for lazy evaluation demo
    private static String fetchDefaultUser() {
        System.out.println("Fetching default user...");
        return "guest@example.com";
    }
    
    // Custom exception for demo
    static class UserNotFoundException extends RuntimeException {
        UserNotFoundException() {
            super("User not found");
        }
    }
    
    // Sample User class
    static class User {
        private String email;
        
        User(String email) {
            this.email = email;
        }
        
        String getEmail() {
            return email;
        }
    }

    public static void main(String[] args) {
        // Example 1: Basic Optional creation and default values
        Optional<String> optionalUser = Optional.ofNullable(findUserById(123));
        
        // Default if null
        String username1 = optionalUser.orElse("guest");
        System.out.println("Username (orElse): " + username1);
        
        // Lazy-evaluated default
        String username2 = optionalUser.orElseGet(() -> fetchDefaultUser());
        System.out.println("Username (orElseGet): " + username2);
        
        // Throw exception if null (commented to prevent program termination)
        // String username3 = optionalUser.orElseThrow(() -> new UserNotFoundException());
        // System.out.println("Username (orElseThrow): " + username3);
        
        // Example 2: Working with a User object
        User user = new User("  ADMIN@EXAMPLE.COM  ");
        Optional<String> optionalEmail = Optional.ofNullable(user.getEmail());
        
        // Transform if present
        Optional<String> sanitizedEmail = optionalEmail.map(String::trim)
                                                    .map(String::toLowerCase);
        sanitizedEmail.ifPresent(email -> 
            System.out.println("Sanitized email: " + email));
        
        // Filter valid emails
        Optional<String> validEmail = optionalEmail.filter(e -> e.contains("@"));
        System.out.println("Valid email present? " + validEmail.isPresent());
        
        // Example 3: Chaining operations
        Optional.ofNullable(findUserById(999))  // This will return empty
               .map(String::toUpperCase)
               .ifPresentOrElse(
                   email -> System.out.println("Found email: " + email),
                   () -> System.out.println("No email found for ID 999")
               );
        
        // Example 4: Exception handling with Optional
        try {
            String email = Optional.ofNullable(findUserById(456))  // Will be empty
                                 .orElseThrow(UserNotFoundException::new);
        } catch (UserNotFoundException e) {
            System.out.println("Caught exception: " + e.getMessage());
        }
    }
}