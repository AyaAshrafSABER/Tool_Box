package toolbox;

import java.util.*;

public class PrimitiveCalculator {
	private static Scanner scanner;

	private static List<Integer> DP(int n) {
		int[] min = new int[n + 1];
		int[] parent = new int[n + 1];
		min[0] = 0;
		min[1] = 0;
		for (int i = 2; i <= n; i++) {
			min[i] = 100000000;
			for (int j = 3; j >= 2; j--) {
				if (i % j == 0) {
					int temp = min[i / j] + 1;
					if (min[i] > temp) {
						min[i] = temp;
						parent[i] = i / j;
					}
				}
			}
			if ( min[i] > (min[i - 1] + 1)) {

				min[i] = min[i - 1] + 1;
				parent[i] = i - 1;
			}
		}
		List<Integer> ret = new ArrayList<Integer>();
		ret.add(n);
		for (int i = n; i >= 2;) {
			ret.add(parent[i]);
			i = parent[i];
		}
		Collections.reverse(ret);
		return ret;

	}

	// private static List<Integer> optimal_sequence(int n) {
	// List<Integer> sequence = new ArrayList<Integer>();
	// while (n >= 1) {
	// sequence.add(n);
	// if (n % 3 == 0) {
	// n /= 3;
	// } else if (n % 2 == 0) {
	// n /= 2;
	// } else {
	// n -= 1;
	// }
	// }
	// Collections.reverse(sequence);
	// return sequence;
	// }

	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		// List<Integer> sequence = optimal_sequence(n);
		List<Integer> sequence = DP(n);
		System.out.println(sequence.size() - 1);
		for (Integer x : sequence) {
			System.out.print(x + " ");
		}
	}
}
