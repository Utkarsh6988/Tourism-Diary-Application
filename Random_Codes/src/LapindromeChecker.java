//A string is a Lapindrome if it can be split into two equal halves where the second half is an anagram of the first half 
//(or vice versa). For strings with odd length, the middle character is ignored.

//Explanation:
//Edge Cases Handling:

//Returns false for null or strings shorter than 2 characters

//Splitting the String:

//For even length: split exactly in middle (e.g., "abba" → "ab" and "ba")
//For odd length: ignore middle character (e.g., "rotor" → "ro" and "or")

//Anagram Check:

//Converts both halves to char arrays
//Sorts both arrays
//Compares if sorted arrays are identical

import java.util.Arrays;

public class LapindromeChecker {
     
	public static boolean isLapindrome(String s) {
		if(s==null || s.length()<2) {
			return false;
		}
		
		int l= s.length();
	    int half= l/2;
	    
	    String firstHalf=s.substring(0, half);
	    String secondHalf=s.substring(l%2==0 ? half : half+1);
	    
       //Anagram Check
	    char[] firstArray = firstHalf.toCharArray();
	    char[] secondArray = secondHalf.toCharArray();
	    Arrays.sort(firstArray);
	    Arrays.sort(secondArray);
	    
	    return Arrays.equals(firstArray,secondArray);
	    
	}
	
	
	public static void main(String[] args) {
        String[] testCases = {"abba", "rotor", "xyzxy", "abcd", "aabbaa", "abcabc"};
        
        for (String test : testCases) {
            System.out.printf("'%s' is lapindrome? %b%n", test, isLapindrome(test));
        }
	}

}
