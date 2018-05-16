package toolbox;

import java.util.Arrays;
import java.util.Scanner;

public class dot_product {
	private static Scanner scan;

	public static void main(String[] args) {
		scan = new Scanner (System.in);
		int n =scan.nextInt();
		long [] a = new long [n];
		long [] b = new long [n];
		for (int i = 0 ; i<n ; i++){
			a[i]=scan.nextLong();
		}
		for (int i = 0 ; i<n ; i++){
			b[i]=scan.nextLong();
		}
		Arrays.sort(a);
		Arrays.sort(b);
		long  maxiume = 0;
		for (int i = 0 ; i<n ;i++){
			maxiume = maxiume + a[i]*b[i];
		}

		System.out.println(maxiume);

	}
	
}
