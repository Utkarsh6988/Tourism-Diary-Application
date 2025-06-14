import java.util.*;

public class LambdaExample2 {
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(3, 1, 2);
		list.sort((a, b) -> b - a);
		System.out.println(list);
	}
}


//Lambda Comparator:
//
//(a, b) are the two elements being compared
//
//b - a determines the sort order:
//
//If result is positive: a comes after b (descending)
//
//If result is negative: a comes before b
//
//If result is zero: elements are equal