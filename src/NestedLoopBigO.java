import java.util.Scanner;

public class NestedLoopBigO {
	public static void main(String[] args) {
		int count = 0;
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		
		//They have the same, essentially, the same big O due to the property.
		//Combination - order doesnt matter, using the formula
		//O(n^3/6 - n^2/2 - n/2) = O(n^3)
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n - 1; j++) {
				for (int k = j + 1; k < n - 1; k++) {
					count++;
				}
			}
		}
		System.out.println("With Bounds: " + count);
		
		//Permutation - order matters, repetitions within the 3 selections are allowed
		//i, j, k are independent and each loop can have different set of n values
		//O(n^3)
		count = 0;
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - 1; j++) {
				for (int k = 0; k < n - 1; k++) {
					count++;
				}
			}
		}
		System.out.println("Without Bounds: " + count);
	}
}
