//Create an array list with 6 elements and display the elements using Lambda Expression  

import java.util.*;
interface B{
	
	void display();
}

public class Example2 {
	public static void main(String args[]) {
    ArrayList<Integer> list = new ArrayList<>();
    
    list.add(1);
    list.add(2);
    list.add(3);
    list.add(4);
    list.add(5);
    
    B ref1 = () -> {                                                    // No argument lambda expression 
        list.forEach(element -> System.out.print(element+ " "));
    };
    
    ref1.display();
}
}
