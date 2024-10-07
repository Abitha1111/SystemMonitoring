package MentorEvaluation;

import java.util.Scanner;

public class twostring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the String1 :");
		String str1 = sc.next();
		System.out.println("Enter the String2 :");
		String str2 = sc.next();
		StringBuilder result = new StringBuilder();

		for (int i = 0; i < str1.length(); i++) {
			if (str1.charAt(i) != str2.charAt(i)) {
				result.append(str1.charAt(i));
				result.append(str2.charAt(i));
			}
		}
		System.out.println(result);
	}
}
