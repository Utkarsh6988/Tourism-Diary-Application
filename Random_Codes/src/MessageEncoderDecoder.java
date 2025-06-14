public class MessageEncoderDecoder {

    public static String decode(String encrypted) {
        StringBuilder result = new StringBuilder();
        int i = 0;
        while (i < encrypted.length()) {
            char currentChar = encrypted.charAt(i++);
            StringBuilder countStr = new StringBuilder();
            
            // Collect all digits following the character
            while (i < encrypted.length() && Character.isDigit(encrypted.charAt(i))) {
                countStr.append(encrypted.charAt(i++));
            }
            
            int count = countStr.length() > 0 ? Integer.parseInt(countStr.toString()) : 1;
            for (int j = 0; j < count; j++) {
                result.append(currentChar);
            }
        }
        return result.toString();
    }

    public static String encode(String plain) {
        if (plain.isEmpty()) return "";
        
        StringBuilder result = new StringBuilder();
        int count = 1;
        char currentChar = plain.charAt(0);
        
        for (int i = 1; i < plain.length(); i++) {
            if (plain.charAt(i) == currentChar) {
                count++;
            } else {
                result.append(currentChar);
                if (count > 1) {
                    result.append(count);
                }
                currentChar = plain.charAt(i);
                count = 1;
            }
        }
        
        // Append the last character(s)
        result.append(currentChar);
        if (count > 1) {
            result.append(count);
        }
        
        return result.toString();
    }

    public static void main(String[] args) {
        String encoded = "a3b1c2d";
        String decoded = "aaabccd";
        
        System.out.println("Decoding '" + encoded + "': " + decode(encoded));
        System.out.println("Encoding '" + decoded + "': " + encode(decoded));
        
        // Additional test cases
        System.out.println("\nAdditional Tests:");
        System.out.println("Decode 'x3y2z': " + decode("x3y2z"));      // xxxyyz
        System.out.println("Decode 'abc': " + decode("abc"));          // abc
        System.out.println("Decode 'a1b2c3': " + decode("a1b2c3"));    // abbccc
        
        System.out.println("Encode 'xxxyyz': " + encode("xxxyyz"));    // x3y2z
        System.out.println("Encode 'abc': " + encode("abc"));          // abc
        System.out.println("Encode 'abbccc': " + encode("abbccc"));    // a1b2c3
    }
}