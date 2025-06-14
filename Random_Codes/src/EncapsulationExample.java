//Encapsulation is one of the four fundamental OOP concepts that bundles data (variables) 
//and methods that operate on that data into a single unit (class), 
//and restricts direct access to some of the object's components.
//
//Key Points of Encapsulation:
//Data Hiding: The variables are declared as private to prevent direct access
//
//Access via Methods: Public getter and setter methods provide controlled access
//
//Validation: Setter methods can include validation logic
//
//Flexibility: Internal implementation can change without affecting other code
//
//Security: Prevents unauthorized access and modification of data


public class EncapsulationExample {
    // Private variables - hidden from outside world
    private String name;
    private int age;
    private double salary;
    
    // Public getter and setter methods to access and modify private variables
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getAge() {
        return age;
    }
    
    public void setAge(int age) {
        if (age > 0) {  // Validation
            this.age = age;
        } else {
            System.out.println("Invalid age value");
        }
    }
    
    public double getSalary() {
        return salary;
    }
    
    public void setSalary(double salary) {
        if (salary >= 0) {  // Validation
            this.salary = salary;
        } else {
            System.out.println("Salary cannot be negative");
        }
    }
    
    public static void main(String[] args) {
    	EncapsulationExample emp = new EncapsulationExample();
        
        // Using setter methods to set values
        emp.setName("John Doe");
        emp.setAge(30);
        emp.setSalary(50000.0);
        
        // Using getter methods to access values
        System.out.println("Employee Name: " + emp.getName());
        System.out.println("Employee Age: " + emp.getAge());
        System.out.println("Employee Salary: " + emp.getSalary());
        
        // Trying to set invalid values
        emp.setAge(-5);      // Will show error message
        emp.setSalary(-100); // Will show error message
    }
}