
import java.util.*;

public class SetExample {
	public static void main(String[] args) {
		Set<String> set = new HashSet<>();
		set.add("A");
		set.add("B");
		set.add("A");
		System.out.println(set.size());
	}
}
