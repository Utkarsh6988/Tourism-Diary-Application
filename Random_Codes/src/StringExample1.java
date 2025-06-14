
//FindSubstringIndex

public class StringExample1 {
    public static void main(String[] args) {
        String sentence = "Welcome to the world of cse";
        String target = "cse";
        
        int index = sentence.indexOf(target);
        
        System.out.println("The sentence is: \"" + sentence + "\"");
        System.out.println("The index position of \"" + target + "\" is: " + index);
    }
}