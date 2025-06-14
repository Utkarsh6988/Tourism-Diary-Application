interface D {
	public boolean check(int a);
}

public class PrimeNumberChecker {
	public static void main(String[] args) {
             D ref = (x) -> {
            	 if(x<=1) return false;
            	 if(x==2) return true;
            	 if(x%2==0) return false;
            	 
            	 for(int i=3; i*i<=x;i+=2) {
            		 if(x%i==0) {
            			 return false;
            		 }
            	 }
            	 return true;
             };
             System.out.println("Result: "+ref.check(4));
             System.out.println("Result: "+ref.check(5));
             System.out.println("Result: "+ref.check(19));
	}
}


//D isPrime = (x) -> {
//    if (x <= 1) return false;
//    for (int i = 2; i < x; i++) {
//        if (x % i == 0) return false;
//    }
//    return true;
//};