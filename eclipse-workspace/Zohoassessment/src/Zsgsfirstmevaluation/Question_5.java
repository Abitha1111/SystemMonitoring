package Zsgsfirstmevaluation;

import java.util.Scanner;

public class Question_5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Input : ");
		String alphastring = sc.nextLine();
		StringBuilder string = new StringBuilder();
		for (char c : alphastring.toCharArray()) {
			if (Character.isLetter(c)) {
				string.append(c);
			}
		}
		String reverse = string.toString().toUpperCase();
		char[] arr = reverse.toCharArray();
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - i - 1; j++) {
				if (arr[j] < arr[j + 1]) {
					char temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
		System.out.print("Output :  ");
		for (char reversechar : arr) {
			System.out.print(reversechar + " ");
		}
	}
}













//package Zsgs;
//
//import java.util.Scanner;
//
//public class Question_5 {
//
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		System.out.println("Enter the number : ");
//		int n = sc.nextInt();
//		String[] st = new String[n];
//		String[] str = new String[n];
//		for (int i = 0; i < n; i++) {
//			System.out.println("Enter the string : " + (i + 1));
//			str[i] = sc.next();
//		}
//
//		for (int i = 0; i < str.length; i++) {
//			char[] ch = str[i].toCharArray();
//
//			// sorted using bubble sort
//			for (int k = 0; k < ch.length - 1; k++) {
//				for (int j = 0; j < ch.length - 1 - k; j++) {
//					if (ch[j] > ch[j + 1]) {
//						char temp = ch[j];
//						ch[j] = ch[j + 1];
//						ch[j + 1] = temp;
//					}
//				}
//			}
//
//			// convert sort array in reverse order
//			String reverse = "";
//			for (int j = ch.length - 1; j >= 0; j--) {
//				reverse += ch[j];
//
//			}
//			st[i] = reverse;
//			reverse = "";
//		}
//
//		System.out.println("The output string is :");
//		for (String s : st) {
//			System.out.println(s);
//		}
//	}
//}