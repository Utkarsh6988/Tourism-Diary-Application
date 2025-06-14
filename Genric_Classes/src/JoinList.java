import java.util.*;
class C< T extends Comparable<T>>
{
	void joinList(List<T>l1,List<T>l2) {
		l1.addAll(l2);
		Collections.sort(l1);
		System.out.println(l1);
		
		
	}
}

public class JoinList {
	public static void main(String[] args) {
		List<Integer>l1= new ArrayList<>(Arrays.asList(21,45,34,12,67));
		List<Integer> l2=new ArrayList<>(Arrays.asList(23,67,89,43,56));
		
		C<Integer>obj=new C<>();
		obj.joinList(l1,l2);
	}
	
	

}