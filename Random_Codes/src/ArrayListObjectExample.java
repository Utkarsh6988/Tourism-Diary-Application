// Create Array List with 3 string objects and 3integer objects , while iterating replaces all string objects with uppercase characters, insert the the number 20after the second integer object 

import java.util.*;
public class ArrayListObjectExample {

	public static void main(String[] args) {
		
		ArrayList<Object> list = new ArrayList<>();
		list.add("Banana");
		list.add(1);
		list.add("Mango");
		list.add(2);
		list.add("Apple");
		list.add(3);
		
		for(int i=0;i<list.size();i++) {
			if(list.get(i) instanceof String) {
				String upper = ((String)list.get(i)).toUpperCase();
				list.set(i, upper);
			}
		}
		
//		list.add(4,20);
      
		int Count=0;
		for(int i=0;i<list.size();i++) {
			if(list.get(i) instanceof Integer) {
				Count++;
				if(Count==2) {
					list.add(i+1,20);
				    break;
			}
		}
	}
		System.out.println("Final List:"+list);
	}

}
