
public class TrimWhitespace {

	public static void main(String[] args) {
		
		String original = "   Hello World!   ";
		String trimmed = original.trim();
		System.out.println(trimmed);  
		
		String unicodeSpaces = "\u2000Hello World!\u2000";
		System.out.println(unicodeSpaces.trim().length());   // Won't remove Unicode spaces
		System.out.println(unicodeSpaces.strip().length());  // Will remove Unicode spaces
		
		// Trim leading spaces only 
		String leadingTrimmed = original.stripLeading();
		System.out.println(leadingTrimmed);  

		// Trim trailing spaces only 
		String trailingTrimmed = original.stripTrailing();
		System.out.println(trailingTrimmed); 

	}

}
