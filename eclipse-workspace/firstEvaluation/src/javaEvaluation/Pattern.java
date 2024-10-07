package javaEvaluation;

import java.util.Scanner;

public class Pattern {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.print("Enter the Input: ");
		char x = s.nextLine().charAt(0);

		char ch = Character.toUpperCase(x);

		int n = ch - 'A' + 1;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				System.out.print(" ");
			}
			System.out.print((char) ('A' + i));
			
			if (i > 0) {
				for (int j = 0; j < 2 * i - 1; j++) {
					System.out.print(" ");
				}
				System.out.print((char) ('A' + i));
			}
			System.out.println();
		}

		for (int i = n - 2; i >= 0; i--) {
			for (int j = 0; j < n - i - 1; j++) {
				System.out.print(" ");
			}
			System.out.print((char) ('A' + i));
			if (i > 0) {
				for (int j = 0; j < 2 * i - 1; j++) {
					System.out.print(" ");
				}
				System.out.print((char) ('A' + i));
			}
			System.out.println();
		}
	}
}
