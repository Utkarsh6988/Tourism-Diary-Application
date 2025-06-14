import java.util.*;

public class IteratorExample {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("X", "Y", "Z");
		Iterator<String> it = list.iterator();
		while (it.hasNext()) {
			System.out.print(it.next() + " ");
		}
	}
}