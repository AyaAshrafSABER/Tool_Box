package toolbox;

import java.util.*;
import java.io.*;

public class MajorityElement {
	private static int getMajorityElement(int[] a, int left, int right) {

		int count = 0;
		int i = left;
		int majority = a.length / 2;
		for (int j = 0; j < a.length; ) {
			while (i < a.length && a[left] == a[i]) {
				count++;
				i++;
				if (count > majority) {
					return 1;
				}
			}
			left = i ;
			j= i ; 
			count = 0 ; 
		}
		return -1;
	}

	private static int naviesolution(int[] a) {
		for (int i = 0; i < a.length; i++) {
			int element = a[i];
			int count = 0;
			for (int j = 0; j < a.length; j++) {
				if (element == a[j]) {
					count++;
				}
				if (count > (a.length / 2)) {
					return 1;
				}
			}
		}
		return -1;

	}

	public static void main(String[] args) {
		//stressTest();
		FastScanner scanner = new FastScanner(System.in);
		int n = scanner.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = scanner.nextInt();
		}
		Arrays.sort(a);
		if (getMajorityElement(a, 0, a.length) != -1) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}
	}

	private static void stressTest() {
		// TODO Auto-generated method stub
		Random rand = new Random();
		int re1 = 0, re2 = 0;
		int counter = 1;
		while (re1 == re2) {
			int n = rand.nextInt(100000);
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = rand.nextInt(1000000000);
				System.out.print(arr[i] + " ");
			}
			System.out.println();
			System.out.println(n + "  this is loop number " + counter);
			re2 = naviesolution(arr);
			Arrays.sort(arr);
			re1 = getMajorityElement(arr, 0, arr.length);
			System.out.println(re2 + "  " + re1);
			counter++;
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
