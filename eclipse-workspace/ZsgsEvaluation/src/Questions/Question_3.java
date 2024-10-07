//package Questions;
//
//import java.util.Scanner;
//
//public class Question_2 {
//
//	public static void main(String[] args) {
//		Scanner scanner = new Scanner(System.in);
//		System.out.print("Enter a number: ");
//		int number = scanner.nextInt();
//		if (isJumbledNumber(number)) {
//			System.out.println(number + " is a jumbled number.");
//		} else {
//			System.out.println(number + " is not a jumbled number.");
//		}
//	}
//
//	static boolean isJumbledNumber(int num) {
//		int[] digits = Integer.toString(num).chars().toArray();
//		for (int i = 0; i < digits.length - 1; i++) {
//			if (Math.abs(digits[i] - digits[i + 1]) != 1) {
//				return false;
//			}
//		}
//		return true;
//	}
//}

//import java.util.Scanner;
//
//public class Question_5 {
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		System.out.print("Input : ");
//		String S1 = sc.nextLine();
//		StringBuilder string = new StringBuilder();
//		for (char c : S1.toCharArray()) {
//			if (Character.isLetter(c)) {
//				string.append(c);
//			}
//		}
//		String reverse = string.toString().toUpperCase();
//
//		char[] arr = reverse.toCharArray();
//		for (int i = 0; i < arr.length - 1; i++) {
//			for (int j = 0; j < arr.length - 1; j++) {
//				if (arr[j] < arr[j + 1]) {
//					char temp = arr[j];
//					arr[j] = arr[j + 1];
//					arr[j + 1] = temp;
//				}
//			}
//		}
//		System.out.print("Output :  ");
//		for (char c : arr) {
//			System.out.print(c + " ");
//		}
//	}
//	}
package Questions;

import java.util.regex.Pattern;
import java.util.Scanner;
import java.util.regex.Matcher;

public class Question_3 {
	public static boolean isValidExpression(String expression) {
		String regex = "^(\\([^()]*\\))*$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(expression);
		return matcher.matches();
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Expression : ");
		String s = sc.nextLine();
		System.out.println("Input: " + s);
		System.out.println("Output: " + (isValidExpression(s) ? "Valid" : "Invalid"));
		System.out.println();
	}
}