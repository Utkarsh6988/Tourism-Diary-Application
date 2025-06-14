
public class CompareStringExample {

	public static void main(String[] args) {
		String str1 = "hello";
		String str2 = new String("hello");
		String str3 = "world";

		// equals()
		System.out.println(str1.equals(str2));  // Output: true (content is the same)
		System.out.println(str1.equals(str3));  // Output: false (content is different)

		// compareTo()
		System.out.println(str1.compareTo(str2)); // Output: 0 (strings are equal)
		System.out.println(str1.compareTo(str3)); // Output: -15 (str1 comes before str3 lexicographically)
		System.out.println(str3.compareTo(str1)); // Output: 15 (str3 comes after str1 lexicographically)  

	}

}


//Why -15 Specifically?
//When comparing "hello" and "world":
//
//The method compares characters one by one until it finds a difference
//
//First differing characters: 'h' (from "hello") and 'w' (from "world")
//
//It calculates the difference between their ASCII/Unicode values:
//
//'h' has Unicode value 104
//
//'w' has Unicode value 119
//
//Difference: 104 - 119 = -15