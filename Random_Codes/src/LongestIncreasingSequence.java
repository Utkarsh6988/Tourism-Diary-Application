
public class LongestIncreasingSequence {

	public static void LongestIncreasingSeq(int input1, int[] input2) {

		if (input1 == 0) {
			System.out.println(0);
			return;
		}

		int c = 1; // At least one element is always an increasing sequence
		int max = 1;

		for (int i = 0; i < input1 - 1; i++) {
			if (input2[i + 1] > input2[i]) {
				c++;
				if (c > max) {
					max = c;
				}
			} else {
				c = 1;
			}
		}
		System.out.println(max);
	}

	public static void main(String[] args) {
		int input1 = 9;
		int input2[] = { 11, 3, 4, 7, 8, 12, 2, 3, 7 };

		LongestIncreasingSeq(input1, input2);
	}
}
