package toolbox;

import java.util.*;

public class DifferentSummands {
	private static Scanner scanner;

	private static List<Integer> optimalSummands(int n) {
		List<Integer> summands = new ArrayList<Integer>();
		int k = n - 1;
		summands.add(1);
		for (int i = 1; i < n && k > 0; i++) {
			if (summands.get(i - 1) < k) {
				summands.add(i + 1);
				k = k - (i + 1);
			} else {
				int sum = summands.get(i - 1) + k;
				summands.remove(i - 1);
				summands.add(sum);
				k = 0;
			}

		}
		return summands;
	}

	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		if (n > 0) {
			List<Integer> summands = optimalSummands(n);
			System.out.println(summands.size());
			for (Integer summand : summands) {
				System.out.print(summand + " ");
			}
		}else{
			System.out.println(0);
			System.out.println(0);
		}
	}
}
