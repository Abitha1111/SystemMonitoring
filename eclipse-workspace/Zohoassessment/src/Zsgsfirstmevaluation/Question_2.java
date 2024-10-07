package Zsgsfirstmevaluation;

import java.util.Scanner;

public class Question_2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter a number: ");
		int number = scanner.nextInt();

		if (isJumbledNumber(number)) {
			System.out.println(number + " is a jumbled number.");
		} else {
			System.out.println(number + " is not a jumbled number.");
		}
	}

	static boolean isJumbledNumber(int num) {
		int[] digits = Integer.toString(num).chars().map(c -> c - '0').toArray();

		for (int i = 0; i < digits.length - 1; i++) {
			if (Math.abs(digits[i] - digits[i + 1]) != 1) {
				return false;
			}
		}
		return true;
	}
}