import java.util.*;

public class ArrayListMerged {
	public static void main(String args[]) {
		
		ArrayList<Integer> list1 = new ArrayList<>();
		ArrayList<Integer> list2 = new ArrayList<>();
		
		ArrayList<Integer> Final = new ArrayList<>();
		
		list1.add(5);
		list1.add(3);
		list1.add(2);
		list1.add(9);
		list1.add(3);
		
		list2.add(15);
		list2.add(18);
		list2.add(13);
		list2.add(11);
		list2.add(14);
		
		for(int i =0;i<5;i++) {
			Final.add(list1.get(i));
		}
		for(int i=0;i<5;i++) {
			Final.add(list2.get(i));
		}
		
		Collections.sort(Final);
		
		System.out.println("Final merged list:");
		
		System.out.println(Final);
		
		
	}

}
