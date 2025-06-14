import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class PrimeNumber {
	
	public static void main(String[] args) {
		
		List<Integer> num = Arrays.asList(10,9,8,7,6,5,4,3,2,1);  
		
		List<Integer> res = num.stream()
				.filter(PrimeNumber::isprime)
				.collect(Collectors.toList());
		
		System.out.println(res);
		
	}
	
	public static boolean isprime(int n) {
		if(n<=1) {
			return false;
		}
		for(int i=2;i<n;i++) {
			if(n%i==0) {
				return false;
			}
		}
		return true;
	}

}


//import java.util.Arrays;
//import java.util.List;
//import java.util.stream.Collectors;
//
//public class PrimeNumber {
//    
//    public static void main(String[] args) {
//        
//        List<Integer> num = Arrays.asList(10, 9, 8, 7, 6, 5, 4, 3, 2, 1);
//        
//        List<Integer> res = num.stream()
//            .filter(n -> n > 1 && 
//                         java.util.stream.IntStream.range(2, n)
//                             .allMatch(i -> n % i != 0))
//            .collect(Collectors.toList());
//        
//        System.out.println(res);
//    }
//}

