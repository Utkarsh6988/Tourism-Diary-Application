import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.CopyOnWriteArrayList;

public class CollectionsCodeSnippets {
       public static void main(String[] args) {
		
    	   System.out.print("1. ");
    	   List<String> list = new ArrayList<>(); list.add("A"); list.add("B");
    	   System.out.println(list.get(1));
    	   
    	   System.out.print("2. ");
    	   Set<Integer> set = new HashSet<>(); set.add(1); set.add(1);
    	   System.out.println(set.size());
    	   
    	   System.out.print("3. ");
    	   Map<String, Integer> map = new HashMap<>(); map.put("a", 1); map.put("b", 2);
    	   System.out.println(map.get("a"));
    	   
    	   System.out.print("4. ");
    	   List<String> list1 = new LinkedList<>(); list1.add("X"); list1.add("Y"); list1.remove(0);
    	   System.out.println(list1);
    	   
    	   System.out.print("5. ");
    	   Queue<Integer> q = new LinkedList<>(); q.add(10); q.add(20);
    	   System.out.println(q.poll());  //Integer java.util.Queue.poll() ,Retrieves and removes the head of this queue, or returns null if this queue is empty.

    	   System.out.print("6. ");
    	   Deque<String> deque = new ArrayDeque<>(); deque.add("first"); deque.push("top");
    	   System.out.println(deque.peek());  //peek() retrieves (but does not remove) the first element of the deque
    	   
    	   System.out.print("7. ");
    	   Set<String> treeSet = new TreeSet<>(); treeSet.add("banana"); treeSet.add("apple");
    	   System.out.println(treeSet);  //Tree set returns in sorted form
    	   
    	   System.out.print("8. ");
    	   Map<Integer, String> map1 = new TreeMap<>(); map1.put(3, "C"); map1.put(1, "A"); map1.put(2, "D");
    	   System.out.println(map1);  // Tree Map returns in sorted order of keys.
    	   
    	   System.out.print("9. ");
    	   List<String> list2 = Arrays.asList("A", "B", "C");
    	   System.out.println(list2.contains("B"));
    	   
    	   System.out.print("10. ");
    	   Set<String> set1 = new LinkedHashSet<>(); set1.add("one"); set1.add("two");
    	   System.out.println(set1); //Returns in insertion order, maintains insertion order.
    	   
    	   System.out.print("11. ");
    	   Map<String, String> map2 = new LinkedHashMap<>(); map2.put("key", "value");
    	   System.out.println(map2);
    	   
    	   System.out.print("12. ");
    	   List<Integer> list3 = new ArrayList<>(Arrays.asList(10, 20)); list3.clear();
    	   System.out.println(list3.isEmpty());
    	   
    	   System.out.print("13. ");
    	   PriorityQueue<Integer> pq = new PriorityQueue<>(); pq.add(30); pq.add(10);
    	   System.out.println(pq.peek()); //Internal structure (min-heap),Internal structure: [10, 30] (10 becomes the root as it's smaller)
    	   
    	   System.out.print("14. ");
    	   Map<String, Integer> map3 = new HashMap<>(); map3.put(null, 100);
    	   System.out.println(map3.get(null));
    	   
    	   System.out.print("15. ");
    	   List<String> list4 = Collections.singletonList("Only"); System.out.println(list4); //singletonList ,Returns an immutable list containing only the specified object. The returned list is serializable.
    	   
    	   System.out.print("16. ");
    	   List<Integer> list5 = Arrays.asList(1, 2, 3); list5.set(1, 5); System.out.println(list5); //set(index, element) replaces the element at position 1 (2nd element) with 5
    	   
    	   System.out.print("17. ");
    	   List<String> list6 = new ArrayList<>(); System.out.println(list6.isEmpty());
    	   
    	   System.out.print("18. ");
    	   Set<Integer> set2 = new TreeSet<>(Arrays.asList(3, 2, 1)); System.out.println(set2);
    	   
    	   System.out.print("19. ");
    	   Map<String, Integer> map4 = new HashMap<>(); map4.put("x", 1); map4.remove("x");
    	   System.out.println(map4);

    	   System.out.print("20. ");
    	   Deque<Integer> deque1 = new ArrayDeque<>(); deque1.addFirst(1); deque1.addLast(2);
    	   System.out.println(deque1);
    	   
    	   System.out.print("21. ");
    	   Queue<Integer> queue = new PriorityQueue<>(); queue.add(2); queue.add(1);
    	   System.out.println(queue.poll()); //PriorityQueue returns in min heap that's why answer is 10
    	   
    	   System.out.print("22. ");
    	   List<String> list7 = new CopyOnWriteArrayList<>(); list7.add("A"); list7.add("B");
    	   for(String s : list7) list7.remove(s); System.out.println(list7); 
//    	   Creates a CopyOnWriteArrayList (thread-safe variant of ArrayList)
//
//    	   Adds elements: ["A", "B"]
//
//    	   The for-loop:
//
//    	   CopyOnWriteArrayList creates a snapshot iterator when loop begins
//
//    	   Original list: ["A", "B"]
//
//    	   Snapshot iterator sees ["A", "B"] (immutable during iteration)
//
//    	   First iteration (s="A"): removes "A" → list becomes ["B"]
//
//    	   Second iteration (s="B"): removes "B" → list becomes []
//
//    	   Output: []
    	   
    	   System.out.print("23. ");
    	   Map<String, String> map5 = Collections.emptyMap(); System.out.println(map5.isEmpty());
    	   
    	   System.out.print("24. ");
    	   List<String> list8 = new ArrayList<>(List.of("one", "two")); list8.add("three");
    	   System.out.println(list8);
    	   
    	   System.out.print("25. ");
    	   Map<Integer, String> map6 = new HashMap<>(); map6.put(1, "one"); map6.put(1, "uno");
    	   System.out.println(map6);
    	   
    	   System.out.print("26. ");
    	   Set<String> set3 = new HashSet<>(Arrays.asList("a", "b", "a"));
    	   System.out.println(set3.size());  //HashSet is a collection that does not allow duplicate elements
    	   
    	   System.out.print("27. ");
    	   List<Integer> list9 = Arrays.asList(1, 2, 3); System.out.println(list9.indexOf(2)); //indexOf() searches for the first occurrence of the specified element (2 in this case)
    	   
    	   System.out.print("28. ");
    	   List<String> list10 = new ArrayList<>(Arrays.asList("X", "Y", "Z")); list10.subList(0,
    			   2).clear(); System.out.println(list10);
    			   
    	   System.out.print("29. ");
    	   Map<String, String> map7 = new HashMap<>(); System.out.println(map7.put("k", "v"));
    	   
//    	   put() inserts the key-value pair ("k", "v") into the map
//
//    	   The method returns:
//
//    	   The previous value associated with the key if the key already existed
//
//    	   null if the key was not previously in the map
//
//    	   In this case, since the map was empty, "k" didn't exist before
//
//    	   Output:
//
//    	   The code will print: 29. null
//
//    	   This null indicates that there was no previous value for key "k"
    	   
    	   System.out.print("30. ");
    	   List<Integer> list11 = Arrays.asList(1, 2, 3); Collections.reverse(list11);
    	   System.out.println(list11);

	} 
}
