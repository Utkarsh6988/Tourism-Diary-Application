//Exception Example
//import java.lang.*;

public class MyCalculator {
	
	public static long power(int n,int p) throws Exception {
		if(n<0||p<0) {
			throw new Exception("n or p should not be negetive");
		}
		if(n==0 && p==0) {
			throw new Exception("n and p both should not be zero");
		}
		long result = 1;
		for(int i=0;i<p;i++) {
			result*=n;
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        try {
        	System.out.println(power(2, 3));  // 8
            System.out.println(power(5, 0));  // 1
            System.out.println(power(0, 5));  // 0
            
            // These will throw exceptions
            System.out.println(power(-2, 3)); // Throws "n or p should not be negative"
            System.out.println(power(0, 0));  // Throws "n and p should not be both zero"
        }catch(Exception e) {
        	System.out.println("Error:"+e.getMessage());
        }
	}

}
