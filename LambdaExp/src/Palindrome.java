
interface E{
	public boolean isPalindrome(int a);
}
public class Palindrome {
      public static void main(String[] args) {  
		E ref = (x) -> {
			if(x<0) return false;
			int original=x;
			int reverse =0;
			
			while(x>0) {
				int r = x%10;
				reverse = reverse*10+r;
				x=x/10;	
			}
			
			return reverse==original;
			
		};
		System.out.println("Result: "+ref.isPalindrome(131));
		System.out.println("Result: "+ref.isPalindrome(120));
	}
}
