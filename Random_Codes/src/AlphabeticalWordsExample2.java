
//Given a sentence , arrange the words alphabetically in which words starting with vowel are succeeded by words starting with consonants

import java.util.Arrays;

public class AlphabeticalWordsExample2 {
	

	public static boolean startsWithVowel(String word) {
        if (word == null || word.isEmpty()) {
            return false;
        }

        char firstChar = word.charAt(0);
        return firstChar == 'a' || firstChar == 'e' || firstChar == 'i' ||
               firstChar == 'o' || firstChar == 'u' ||
               firstChar == 'A' || firstChar == 'E' || firstChar == 'I' ||
               firstChar == 'O' || firstChar == 'U';
    }
	public static void main(String[] args) {
		String str1= "I want to go in a vacation";
	    StringBuilder vowels = new StringBuilder();
        StringBuilder consonants = new StringBuilder();
		String words[] = str1.split("\\s+");
		for(String word:words) {
			if(startsWithVowel(word)) {
				vowels.append(word).append(" ");
			}
			else
			{
				consonants.append(word).append(" ");
			}
		}
	      String[] vowelWords = vowels.toString().trim().split("\\s+");
	        String[] consonantWords = consonants.toString().trim().split("\\s+");
		

	        Arrays.sort(vowelWords,String.CASE_INSENSITIVE_ORDER);
	        Arrays.sort(consonantWords,String.CASE_INSENSITIVE_ORDER);
		
	        System.out.print(String.join(" ", vowelWords) + " ");
	        System.out.print(String.join(" ", consonantWords));
	}

}
