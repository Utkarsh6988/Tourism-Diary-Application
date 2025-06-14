//Access the second value, Remove the third item, Display total no. of elements, Display the key and value separately

import java.util.*;
public class HashMapExample {

	public static void main(String[] args) {
		
		HashMap<Integer,String> hm = new HashMap<>();
		
		hm.put(1, "Utkarsh");
		hm.put(2, "Sarthak");
		hm.put(3, "Varun");
		hm.put(4, "Shally");
		hm.put(5, "Raunak");
		
		
//Another approach
//        int count = 0;
//        for (String value :hm.values()) {
//            count++;
//            if (count == 2) {
//                System.out.println("Second value is: " + value);
//                break;
//            }
//        }
		
		
		List<String> valueList = new ArrayList<>(hm.values());
		if(valueList.size()>=2) {
			System.out.println("Second element is:"+ valueList.get(1));
		}
		
		List<Integer> keyList = new ArrayList<>(hm.keySet());
		if(keyList.size()>=3) {
			Integer keyRemove = keyList.get(2);
			hm.remove(keyRemove);
			System.out.println("Removed third item is:"+ keyRemove);
		}
		
		System.out.println("Total no. of elements:"+hm.size());
		
		System.out.println("Keys:");
		for(Integer key:hm.keySet()) {
			System.out.print(key+" ");
		}
		
		System.out.println();
		
		System.out.println("Values:");
		for(String values:hm.values()) {
			System.out.print(values+" ");
		}
			
	}

}




//🔹 In a HashMap, making a List is not strictly necessary to access values, but it becomes necessary if you want to access elements by position (e.g., second value) — because:
//HashMap does not maintain any order (not insertion, not sorting).
//Its .values() method returns a Collection, which does not support index-based access like .get(1).


//The Iterable interface in Java represents a collection of elements that can be iterated over. It is the root interface for the entire collection framework. Any class that implements this interface can be used in a "for-each" loop. 
//Key Features of the Iterable Interface:
//Single Method:
//The Iterable interface has only one method: iterator(). This method returns an Iterator object that is used to traverse the elements of the collection.


