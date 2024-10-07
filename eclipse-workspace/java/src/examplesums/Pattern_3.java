package examplesums;

import java.util.Scanner;

public class Pattern_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println(" Enter the Number :");
		int a = sc.nextInt();
		System.out.println("Enter the Symbol :");
		char ch = sc.next().charAt(0);
		for (int i = a; i >= 1; i--) {
			for (int k = i; k < a; k++) {
				System.out.print(" ");
			}
			for (int j = 1; j <= (2 * i - 1); j++) {
				if (j == 1 || i == a || j == (2 * i - 1)) {
					System.out.print(ch);
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}

}
