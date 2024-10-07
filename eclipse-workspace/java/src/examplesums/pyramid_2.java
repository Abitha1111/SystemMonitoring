package examplesums;

import java.util.Scanner;

public class pyramid_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println(" Enter the Number :");
		int a = sc.nextInt();
	
		for (int i = a; i >= 1; i--) {
			for (int k = i; k <= a; k++) {
				System.out.print(" ");
			}
			for (int j = 1; j <= i; j++) {
				System.out.print(i+ " ");
			}
			System.out.println();
		}
	}

}
