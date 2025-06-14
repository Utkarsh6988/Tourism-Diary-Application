import java.util.*;
public class TwoStringConcatenation {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter two strings");
		String string1=sc.next();
		String string2=sc.nextLine();
		System.out.println("Concatenation of two strings is:"+ string1.concat(string2));
		sc.close();
	}

}
