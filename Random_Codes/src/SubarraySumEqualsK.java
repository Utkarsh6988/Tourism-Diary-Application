import java.util.*;

public class SubarraySumEqualsK {
//	public static int subarraySum(int[]nums, int k) {
//		int count=0;
//		int sum=0;	
//		
//		HashMap<Integer, Integer> map = new HashMap<>();
//		map.put(0, 1);  // sum of zero occurs once
//		
//		for(int num: nums) {
//			sum+=num;
//			if(map.containsKey(sum-k)) {
//				count+=map.get(sum-k);
//			}
//			map.put(sum, map.getOrDefault(sum, 0)+1);
//		}
//		return count;
//	}
	
	//subarraySumBruteForce
	public static int subarraySum(int[] nums, int k) {
	    int count = 0;
	    for (int i = 0; i < nums.length; i++) {
	        int sum = 0;
	        for (int j = i; j < nums.length; j++) {
	            sum += nums[j];
	            if (sum == k) {
	                count++;
	            }
	        }
	    }
	    return count;
	}
	public static void main(String[] args) {
		
		  // Example 1
        int[] nums1 = {1, 1, 1};
        int k1 = 2;
        System.out.println(subarraySum(nums1, k1)); // Output: 2
        
        // Example 2
        int[] nums2 = {2, 3, 1, 1, 2, 6, 2, 2};
        int k2 = 4;
        System.out.println(subarraySum(nums2, k2)); // Output: 3
	}

}
