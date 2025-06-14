
//public class WordFrequency {
//
//	public static void main(String[] args) {
//		String s ="Hello, Hello and Welcome to the world";
//		String target = "Hello";
//		
//		int c =0;
//		int index = s.indexOf(target);
//		
//		while(index!=-1) {
//			c++;
//			index = s.indexOf(target, index+target.length());
//		}
//		System.out.println("The word \"" + target + "\" appears " + c + " times.");
//	}
//
//}

import java.util.*;
public class WordFrequency {

	public static void main(String[] args) {
		String s ="Hello, Hello and Welcome to the world";
		String target = "Hello";
		
		String cleanedString = s.replaceAll("[^a-zA-Z]", "").toLowerCase();
		String cleanedTarget = target.toLowerCase();
		
		String[] words = cleanedString.split("\\s+");
		
		HashMap<String,Integer> frequencyMap = new HashMap<>();
		
		for(String word:words) {
			frequencyMap.put(word,frequencyMap.getOrDefault(word, 0)+1);
		}
		
		int frequency = frequencyMap.getOrDefault(cleanedTarget, 0);
		
		 System.out.println("The word \"" + target + "\" appears " + frequency + " times.");
		 
		 System.out.println("\nWord Frequencies:");
		 for(String word: frequencyMap.keySet()) {
			 System.out.println(word + ": " + frequencyMap.get(word));
		 }
	}
}