package Tenkasiassess;

import java.util.Scanner;

public class substring_5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the String:");
		String input = sc.next();
		System.out.println("Enter the String to search:");
		String search = sc.next();
		System.out.println("Enter Number Of Columns: ");
		int col = sc.nextInt();
		String temp = "";
		int countRow = 0;
		int countCol = 0;
		for (int i = 0; i < input.length(); i++) {
			temp += String.valueOf(input.charAt(i));
			if (temp.length() == search.length()) {
				if (search.equals(temp)) {
					System.out.println("Start Index: " + countRow + "," + (countCol - (search.length() - 1)));
					System.out.println("End Index: " + countRow + "," + countCol);
				} else {
					temp = "";
				}
			}
			countCol++;
			if (countCol == col) {
				temp = "";
				countRow++;
				countCol = 0;
			}
		}
	}
}
