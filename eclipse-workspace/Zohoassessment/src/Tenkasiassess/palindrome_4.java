package Tenkasiassess;

import java.util.Scanner;

public class palindrome_4 {
	// TODO Auto-generated method stud
	public static boolean isPalindrome(String str) {
		StringBuilder sb = new StringBuilder(str);
		return sb.toString().equals(sb.reverse().toString());
	}

	public static String smallestLexicographicallyDP(String str) {
		int n = str.length();
		boolean[][] isPalindrome = new boolean[n][n];
		String[][] bestPalindrome = new String[n][n];
		for (int i = 0; i < n; i++) {
			isPalindrome[i][i] = true;
			bestPalindrome[i][i] = Character.toString(str.charAt(i));
		}

		for (int length = 2; length <= n; length++) {
			for (int i = 0; i < n - length + 1; i++) {
				int j = i + length - 1;
				isPalindrome[i][j] = isPalindrome(str.substring(i, j + 1));
				if (isPalindrome[i][j]) {
					bestPalindrome[i][j] = str.substring(i, j + 1);
				} else {
					if (bestPalindrome[i + 1][j].compareTo(bestPalindrome[i][j - 1]) <= 0) {
						bestPalindrome[i][j] = bestPalindrome[i + 1][j];
					} else {
						bestPalindrome[i][j] = bestPalindrome[i][j - 1];
					}
				}
			}
		}

		return bestPalindrome[0][n - 1];
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a string:");
		String str = scanner.nextLine();
		String smallestPalindrome = smallestLexicographicallyDP(str);
		if (!smallestPalindrome.equals("No")) {
			System.out.println("The lexicographically smallest palindrome is: " + smallestPalindrome);
		} else {
			System.out.println("No palindrome can be formed");
		}
	}
}
