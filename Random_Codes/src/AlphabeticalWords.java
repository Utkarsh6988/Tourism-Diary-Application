//import java.util.*;
//public class AlphabeticalWords {
//
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		System.out.println("Enter a sentence");
//	    String str = sc.nextLine();
//	    
//	    String cleanedString = str.replaceAll("[^a-zA-Z]", "");
//	    
//	    String words[] = cleanedString.split("\\s+");
//	    
//	    List<String> wordList = new ArrayList<>();
//	    for(String word:words) {
//	    	if(!word.isEmpty())
//	    	{
//	    		wordList.add(word.toLowerCase());
//	    	}
//	    }
//	    
//	    Collections.sort(wordList);
//	    System.out.println("Alphabetical Sentence");
//	    for(String word:wordList) {
//	    	System.out.print(word+ " ");
//	    }
//	    sc.close();
//	}
//
//}


//Other approach
import java.util.*;
public class AlphabeticalWords {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a sentence");
	    String str = sc.nextLine();
	    
	    String words[] = str.split("\\s+");
	    
	    Arrays.sort(words);
	    System.out.println(String.join(" " , words));
	    sc.close();
		}
	}