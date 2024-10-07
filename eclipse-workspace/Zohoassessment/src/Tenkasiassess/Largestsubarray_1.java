package Tenkasiassess;

import java.util.Scanner;

public class Largestsubarray_1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Size:");
		int len = sc.nextInt();
		int[] input = new int[len];
		for (int i = 0; i < len; i++) {
			System.out.println("Enter the value of " + (i + 1) + ":");
			input[i] = sc.nextInt();
		}
		int max = 0;
		int start = 0;
		int end = 0;
		for (int i = 0; i < input.length; i++) {
			int temp = 0;
			for (int j = i + 1; j < input.length; j++) {
				temp += input[j];
				if (Math.max(temp, max) > max) {
					max = Math.max(temp, max);
					start = i;
					end = j;
				}
			}
		}
		for (int i = start + 1; i <= end; i++) {
			System.out.print(input[i] + ",");
		}
	}
}