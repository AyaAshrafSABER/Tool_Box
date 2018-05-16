package toolbox;

import java.util.*;

public class LargestNumber {
	private static Scanner scanner;

	private static String largestNumber(String[] a) {
		//sort array of a 
		int len = a.length ; 
		for (int i=0 ;i< len ; i++){
			for (int j=0 ; j< len-i-1 ; j++ ){
				compare(a,j);
			}
		}
		String result = "";
		for (int i = 0; i < a.length; i++) {
			
			result += a[i];
		}
		return result;
	}

	private static void compare(String[] a, int j) {
		// TODO Auto-generated method stub
		String AB = a[j]+a[j+1];
		String BA = a[j+1]+a[j]; 
		if (AB.compareTo(BA)<0){
			swap (a,j);
		}
		
	}

	private static void swap(String[] a, int j) {
		// TODO Auto-generated method stub
		String temp = a[j];
		a[j] =a[j+1];
		a[j+1] =temp;
		
	}

	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		String[] a = new String[n];
		for (int i = 0; i < n; i++) {
			a[i] = scanner.next();
		}
		System.out.println(largestNumber(a));
	}
}
