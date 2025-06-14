import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class AnagramsGroup {
	public static void main(String[] args) {
            String arr[] = {"eat", "tea", "tan", "ate", "nat", "bat"};
            List<List<String>> groupedAnagrams = groupedAnagrams(arr);
//            groupedAnagrams.sort((a, b) -> a.get(0).compareTo(b.get(0))); // Sort groups
            System.out.println("[");
            for(List<String>group: groupedAnagrams) {
            	System.out.println(" "+group+" ,");
            }
            System.out.println("]");
            
	}
	public static List<List<String>> groupedAnagrams(String[] strs){
		if(strs==null || strs.length ==0)
			return new ArrayList<>();
	
	
	Map<String, List<String>> map = new HashMap<>();
	for(String s: strs) {
		char[] charArray = s.toCharArray();
		Arrays.sort(charArray);
		String sorted = new String(charArray);
		
		if(!map.containsKey(sorted)) {
			map.put(sorted, new ArrayList<>());
		}
		map.get(sorted).add(s);
	}
	return new ArrayList<>(map.values());
	}
}
