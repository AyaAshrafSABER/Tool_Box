package toolbox;

import java.util.Scanner;

public class fractional_knapsack {
	static Scanner scan;
	static int[] valueOfItem;
	static int[] weightOfItem;
	static double[] valuePerunit;

	public static void main(String[] args) {
		scan = new Scanner(System.in);
		int numOfItem = scan.nextInt();
		int knapsack = scan.nextInt();
		double answer= 0 ;
		valueOfItem = new int[numOfItem];
		weightOfItem = new int[numOfItem];
		valuePerunit = new double[numOfItem];
		for (int i = 0; i < numOfItem; i++) {
			valueOfItem[i] = scan.nextInt();
			weightOfItem[i] = scan.nextInt();
			valuePerunit[i] = (double)valueOfItem[i] / (double)weightOfItem[i];
		}
		sortArray(numOfItem);
		 for (int i= numOfItem-1 ; i>=0 &&knapsack>0 ; i--){
			int a = min (knapsack , weightOfItem[i]);
			answer = answer + a * valuePerunit[i];
			knapsack = knapsack- a ;
			
		}
		 System.out.printf("%.4f",answer);
			
	}

	private static int min(int knapsack, int i) {
		// TODO Auto-generated method stub
		if (knapsack< i){
			return knapsack;
		}else {
			return i ; 
		}
		
	}

	private static void sortArray(int numOfItem) {
		// TODO Auto-generated method stub
		int flag = 1;
		for (int i = 0; i < numOfItem - 1 && flag == 1; i++) {
			flag = 0;
			for (int j = 0; j < numOfItem - i - 1; j++) {
				if (valuePerunit[j] > valuePerunit[j + 1]) {
					swapF(j, j+1);
					swapI(j, j + 1);
					flag = 1;
				}
			}
		}

	}

	private static void swapI(int i, int j) {
		// TODO Auto-generated method stub
		int temp = valueOfItem[i];
		valueOfItem[i]=valueOfItem[j];
		valueOfItem[j]=temp ;
		temp = weightOfItem [i];
		weightOfItem[i]=weightOfItem[j];
		weightOfItem[j] =temp ;

	}

	private static void swapF(int f, int g) {
		// TODO Auto-generated method stub
		double temp =valuePerunit[f] ;
		valuePerunit[f]=valuePerunit[g];
		valuePerunit[g]=temp ;
	}

}
