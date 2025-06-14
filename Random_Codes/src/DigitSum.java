
public class DigitSum {

	public static int digitSum(int a) {

		if (a < 0) {
			a = -a; // Handle negative numbers (optional)
		}
 
		int sum = 0;
		while (a > 0) {
			int r = a % 10;
			sum += r;
			a = a / 10;
		}
		if (sum >= 10) {
			return digitSum(sum);
		}
		return sum;
	}

	public static void main(String[] args) {

		System.out.println("Result: " + digitSum(976592));
	}

}
