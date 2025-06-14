//Checking if Two Strings Are Isomorphic in Java
//Two strings are isomorphic if the characters in the first string can be replaced to get the second string, with the following rules:
//
//All occurrences of a character must be replaced with another character
//
//No two characters can map to the same character
//
//A character can map to itself

import java.util.*;
public class IsomorphicStrings {
  public static boolean isIsomorphic(String s, String t) {
	  if(s.length()!=t.length()) {
		  return false;
	  }
	  
	  HashMap<Character, Character> charMapping = new HashMap<>();
	  HashSet<Character> mappedChars = new HashSet<>();
	  
	  for(int i=0;i<s.length();i++) {
		  char schar = s.charAt(i);
		  char tchar = t.charAt(i);
		  
		  if (charMapping.containsKey(schar)) {
			  if(charMapping.get(schar)!=tchar) 
				  return false;	
//			  else
//				  continue;
		  }
		  else {
			  if(mappedChars.contains(tchar))
				  return false;
		  }		  
		  charMapping.put(schar,tchar);
		  mappedChars.add(tchar);
	  }
	  return true;
	  
	  //Other approach
//	  public static boolean isIsomorphic(String s, String t) {
//		    if (s.length() != t.length()) return false;
//		    
//		    int[] sMap = new int[256]; // Assuming ASCII characters
//		    int[] tMap = new int[256];
//		    
//		    for (int i = 0; i < s.length(); i++) {
//		        char sChar = s.charAt(i);
//		        char tChar = t.charAt(i);
//		        
//		        if (sMap[sChar] != tMap[tChar]) {
//		            return false;
//		        }
//		        // Store 1-based index (i+1) to distinguish from default 0
//		        sMap[sChar] = i + 1;
//		        tMap[tChar] = i + 1;
//		    }
//		    return true;
//		}
  }
  public static void main(String args[]) {
	  Scanner sc = new Scanner(System.in);
	  System.out.println("Enter two strings");
	  String s = sc.next();
	  String t = sc.next();
	  System.out.println(isIsomorphic(s,t));
	  sc.close();
  }
}


