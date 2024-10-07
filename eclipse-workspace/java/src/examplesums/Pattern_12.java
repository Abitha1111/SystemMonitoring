package examplesums;

import java.util.Scanner;

public class Pattern_12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number :");
		int a = sc.nextInt();
		for (int i = 1; i <= a; i++) {
			for (int j = 1; j <= a; j++) {
				if (i == 1 || j == 1 || i == a || j == a) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}

			}
			System.out.println(" ");
		}
	}

}
