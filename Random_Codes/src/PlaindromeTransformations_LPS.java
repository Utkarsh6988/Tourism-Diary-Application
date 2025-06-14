
public class PlaindromeTransformations_LPS {
	
	public static String canBePalindrome(String s, int k) {
		int n = s.length();
		int lpsLength = longestPalindromicSubsequence(s);
		int minDeletions=n-lpsLength;
		
		if(minDeletions<=k) {
			return String.valueOf(minDeletions);
		}
		else {
			return "Not Possible";
		}
	}
	public static int longestPalindromicSubsequence(String s) {
		int n = s.length(); 
		int[][] dp = new int[n][n];
		
		for(int i=0;i<n;i++) {
			dp[i][i]=1;
		}
		
		for (int cl = 2; cl <= n; cl++) {
            for (int i = 0; i < n - cl + 1; i++) {
                int j = i + cl - 1;
                if (s.charAt(i) == s.charAt(j) && cl == 2) {
                    dp[i][j] = 2;
                } else if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
                }
            }
        }
        
        return dp[0][n - 1];
	}
	
	public static void main(String args[]) {
		System.out.println(canBePalindrome("abcda", 1)); 
        System.out.println(canBePalindrome("abcba", 0));
        System.out.println(canBePalindrome("abcbab", 1));
	}

}
