//Check how many times  string1 present in string2
//
//import java.util.*;
//public class StringCountExample {
//
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		System.out.println("Enter both the strings");
//		String str2=sc.nextLine(); //main string
//		String str1=sc.nextLine();//to be searched
//		
//		int count=0;
//		int index=0;
//		
//		while((index=str2.indexOf(str1,index))!=-1) {
//			count++;
//			index+=str1.length();
//		}
//		System.out.println(str1 +" "+ "appears"+ " " + count +" "+"times in main string");
//		
//		sc.close();
// 
//	}
//
//}

import java.util.*;
public class StringCountExample {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
		System.out.println("Enter both the strings");
		String str2=sc.nextLine(); //main string
		String str1=sc.nextLine();//to be searched
		

        int count = 0;
        int len1 = str1.length();
        int len2 = str2.length();

        for (int i = 0; i <= len2 - len1; i++) {
            if (str2.substring(i, i + len1).equals(str1)) {
                count++;
                i += len1 - 1; // Move past the current match to avoid overlapping
            }
        }

        System.out.println("'" + str1 + "' appears " + count + " times in '" + str2 + "'");
        sc.close();
    }
}