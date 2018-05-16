package toolbox;

import java.util.Scanner;

public class changing_money {
	private static Scanner scan;

	public static void main(String[] args) {
		scan = new Scanner(System.in);
		int input= scan.nextInt();
		int counter = 0;
		while (input > 0){
			if (input>= 10 ){
				counter++;
				input=input-10;
			}else if (input >= 5){
				counter++;
				input= input-5;
			}else{
				counter++;
				input--;
			}
		}
		System.out.println(counter);
		
	}
}
