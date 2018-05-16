
package toolbox;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

/*
 * this class calculate the number of inverse using merge sort and bubble sort 
 * they are applied using the stress Test and they give the same answer ; 
 */
public class Inversions {

	private static FastScanner scanner;

	private static long getNumberOfInversions(int[] a, int[] b, int left, int right) {
		long numberOfInversions = 0;
		if (right <= left + 1) {
			return numberOfInversions;
		}
		int ave = (left + right) / 2;
		numberOfInversions += getNumberOfInversions(a, b, left, ave);
		numberOfInversions += getNumberOfInversions(a, b, ave, right);
		numberOfInversions += Merge(a, b, left, ave, right);
		return numberOfInversions;
	}

	private static long Merge(int[] a, int[] b, int left, int ave, int right) {
		// TODO Auto-generated method stub
		int i = left;
		int j = ave;
		int bCounter = left;
		long re = 0;
		while (i < ave && j < right) {
			if (a[j] < a[i]) {
				re += j - (bCounter);
				b[bCounter] = a[j];
				bCounter++;
				j++;
			} else {
				b[bCounter] = a[i];
				bCounter++;
				i++;
			}
		}
		while (i < ave) {
			b[bCounter] = a[i];
			bCounter++;
			i++;
		}
		while (j < right) {
			b[bCounter] = a[j];
			bCounter++;
			j++;
		}
		for (int k = left; k < right; k++) {
			a[k] = b[k];
		}

		return re;
	}

	public static long BubbleSort(int[] a) {
		long inverse = 0;
		int len = a.length;
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len - 1 - i; j++) {
				if (a[j] > a[j + 1]) {
					inverse++;
					int temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
				}
			}
		}
		return inverse;
	}

	public static void main(String[] args) {
		// stress();
		scanner = new FastScanner(System.in);
		int n = scanner.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = scanner.nextInt();
		}
		int[] b = new int[n];
		// System.out.println(BubbleSort(a));
		System.out.println(getNumberOfInversions(a, b, 0, a.length));

	}

	private static void stress() {
		// TODO Auto-generated method stub
		Random rand = new Random();
		long re1 = 0;
		long re2 = 0;
		while (re1 == re2) {
			int n = rand.nextInt(100000) + 1;
			System.out.println(n + " ");
			int[] a1 = new int[n];
			int[] a2 = new int[n];
			for (int i = 0; i < n; i++) {
				a1[i] = rand.nextInt(1000000000) + 1;
				a2[i] = a1[i];
				System.out.print(a1[i] + "  ");
			}
			int[] b = new int[n];
			re1 = BubbleSort(a1);
			re2 = getNumberOfInversions(a2, b, 0, a2.length);
			System.out.println(re1 + " " + re2);
		}

	}

	static class FastScanner {
		BufferedReader br;
		StringTokenizer st;

		FastScanner(InputStream stream) {
			try {
				br = new BufferedReader(new InputStreamReader(stream));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		String next() {
			while (st == null || !st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}
	}
}
