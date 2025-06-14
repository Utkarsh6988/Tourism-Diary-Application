import java.util.Optional;

public class OptionalClass {
	public static void main(String[] args) {

//	   String x= null;
//	   Optional<String> op = Optional.ofNullable(x);    //create an optional object
//	   System.out.println(op.isPresent());               // returns true if there is present
////       System.out.println(op.get())           //It will give NoSuchElementException because no value entered
//       System.out.println(op.orElse("No value in this object"));

		String x = "Hello";
		Optional<String> op = Optional.ofNullable(x); // create an optional object
		System.out.println(op.isPresent()); // returns true if there is present
		System.out.println(op.get());
		System.out.println(op.orElse("No value in this object"));
	}
}
