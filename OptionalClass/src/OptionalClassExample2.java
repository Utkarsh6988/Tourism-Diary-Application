import java.util.Optional;

public class OptionalClassExample2 {
	public static void main(String[] args) {
		int x = 0;
		Optional<Integer> op = Optional.ofNullable(x); // create an optional object
		System.out.println(op.isPresent()); // returns true if there is present
		System.out.println(op.get());
//       System.out.println(op.orElse("No value in this object"));
	}
}
