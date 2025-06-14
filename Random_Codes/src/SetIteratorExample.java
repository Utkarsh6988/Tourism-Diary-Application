//Retrieval of elements from set using iterator

import java.util.*;
public class SetIteratorExample {
	public static void main(String[]args) {
		
		// unordered output
		
		Set<Integer> set = new HashSet<>();
		set.add(10);
		set.add(20);
		set.add(30);
		set.add(40);
		set.add(50);
		set.add(60);
		
		Iterator<Integer> iterator = set.iterator();
		
		System.out.println("Elements of set:");
		while(iterator.hasNext()){
		Integer element = iterator.next();
		System.out.print(element+ " ");
		}
		
		System.out.println();
		
		// for return in order
		
		Set<Integer> set1 = new LinkedHashSet<>();
		set1.add(10);
		set1.add(20);
		set1.add(30);
		set1.add(40);
		set1.add(50);
		set1.add(60);
		
		Iterator<Integer> iteratorLinked = set1.iterator();
		
		System.out.println("Elements of set in order :");
		while(iteratorLinked.hasNext()){
		Integer element = iteratorLinked.next();
		System.out.print(element+ " ");
		}
	}

}
