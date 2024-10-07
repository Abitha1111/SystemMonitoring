package Batch5evaluation;

import java.util.*;

public class password {
	static String passwordCracker(String[] passwords, String attempt) {
		StringBuilder result = new StringBuilder();
		int n = attempt.length();
		int m = passwords.length;

		int[] len = new int[m];
		for (int i = 0; i < m; i++) {
			len[i] = passwords[i].length();
		}

		for (int i = 0; i < n;) {
			int j;
			for (j = 0; j < m; j++) {
				int l = len[j];
				if (i + l <= n && attempt.substring(i, i + l).equals(passwords[j])) {
					result.append(passwords[j]).append(" ");
					i += l;
					break;
				}
			}
			if (j == m) {
				return "WRONG PASSWORD";
			}
		}
		return result.toString().trim();
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		while (t-- > 0) {
			int n = scanner.nextInt();
			String[] passwords = new String[n];
			for (int i = 0; i < n; i++) {
				passwords[i] = scanner.next();
			}
			String attempt = scanner.next();
			System.out.println(passwordCracker(passwords, attempt));
		}
		scanner.close();
	}
}
