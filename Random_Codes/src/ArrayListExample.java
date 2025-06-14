//Change third element , remove fourth element, display total no. of elements, traverse all the elements using for each loop , Display all elements after sorting, Remove all the elements of array List

import java.util.*;
public class ArrayListExample {

	public static void main(String[] args) {
		
		ArrayList<String> list = new ArrayList<>();
		
		list.add("Utkarsh");
		list.add("Sarthak");
		list.add("Raunak");
		list.add("Varun");
		list.add("Noor");
		
		list.set(2, "Raunak Arora");
		
		list.remove(3); 
		
		System.out.println("Total no. of elements:"+list.size());
		
		
		System.out.println("List of all elements:");
		for(String al:list) {
			System.out.print(al+" ");
		}
		
		Collections.sort(list);  //Collection is the interface and Collections is class
		
		System.out.println();
		
		System.out.println("Sorted list of all elements:");
		for(String al:list) {
			System.out.print(al+" ");
		}
		System.out.println();
		
        list.clear();
        
        System.out.println("After clearing list of all elements:"+list);
	}

}
