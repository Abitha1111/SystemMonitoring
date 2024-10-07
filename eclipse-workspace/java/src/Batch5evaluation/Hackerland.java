package Batch5evaluation;

import java.util.Scanner;

public class Hackerland {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
//	        int count = 0;
		System.out.print("Enter Expenditure size: ");
		int s = scanner.nextInt();
		int X = 1;
		System.out.print("Enter weekday ");
		int Y = scanner.nextInt();
		int[] A = new int[s];
		System.out.println("Enter the expenditure: ");
		for (int i = 0; i < s; i++) {
			A[i] = scanner.nextInt();
		}
		int result = valuesInBetween(s, X, Y, A);
		System.out.println(result);
	}

	public static int valuesInBetween(int s, int X, int Y, int[] A) {
//	        ArrayList<Integer> result = new ArrayList<>();
		int count = 0;
		for (int i = 0; i < s; i++) {
			if (Y < A[i]) {
//	                int count = 0;
				count++;
			}
		}
//	        ArrayList<Integer> count = 0;
		return count;
	}
}
