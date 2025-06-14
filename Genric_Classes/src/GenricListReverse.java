//To define a generic method of any type which will take a list and print the elements in reverse order.

import java.util.*;

class B<T> // B is a generic type parameter
{

	public static <T> void reverse(List<T> list) // T is a return type here , reverse() is a generic method
	{
		List<T> reversed = new ArrayList<>(list);
		Collections.reverse(reversed);

		for (T element : reversed) {
			System.out.print(element + " ");
		}
	}
}

public class GenricListReverse {
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
		System.out.println("Reversed Integer List: ");
		B.reverse(list);

		List<String> strList = Arrays.asList("Apple", "Banana", "Cherry");
		System.out.println("\nReversed String list:");
		B.reverse(strList);
	}

}
