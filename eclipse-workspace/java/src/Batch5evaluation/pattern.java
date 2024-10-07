package Batch5evaluation;

import java.util.Scanner;

public class pattern {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the input value");
		int n = input.nextInt();
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (i == 1 || i == n || j == 1 || j == n) {
					System.out.print("1");
				} else if (i % 2 != 0 && j % 2 != 0) {
					System.out.print("1");
				} else {
					System.out.print("0");
				}

			}
			System.out.println();
		}

	}

}
