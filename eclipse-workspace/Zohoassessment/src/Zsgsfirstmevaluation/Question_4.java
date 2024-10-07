package Zsgsfirstmevaluation;

import java.util.Scanner;

public class Question_4 {

	public static void main(String[] args) {
		Scanner mc = new Scanner(System.in);
		System.out.println("Enter the String :");
		String string = mc.next();
		System.out.println("Enter the rows : ");
		int n = mc.nextInt();
		convert(string, n);

	}

	public static void convert(String s, int rows) {

		int column = 2 * rows;
		int index = 0, i = 0, j = 0;
		char array[][] = new char[rows][column];

		while (index < s.length()) {

			// FIRST COLUMN
			if (i == 0) {
				while (i < rows && index < s.length()) {
					array[i][j] = s.charAt(index);
					index++;
					i++;

				}
			}

			// SECOND COLUMN
			if (i == rows) {
				i--;
				while (i > 0 && index < s.length()) {
					i--;
					j++;
					array[i][j] = s.charAt(index);
					index++;
				}
			}
			if (index < s.length())
				index--;
			else
				break;
		}
		printArray(array, rows, column);

	}

	private static void printArray(char[][] array, int rows, int column) {

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < column; j++) {
				if (Character.isLetter(array[i][j]))
					System.out.print(array[i][j] + " ");
				else
					System.out.print("  ");

			}
			System.out.println();
		}
	}

}