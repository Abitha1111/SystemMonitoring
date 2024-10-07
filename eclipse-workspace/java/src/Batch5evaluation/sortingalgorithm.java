package Batch5evaluation;

import java.util.Scanner;

public class sortingalgorithm {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter number of elements: ");
		int n = input.nextInt();
		int[] arr = new int[n];

		System.out.println("Enter " + n + " elements:");
		for (int i = 0; i < n; i++) {
			arr[i] = input.nextInt();
		}

		insertionSort(arr);

		System.out.println("Sorted array: ");
		for (int i = 0; i < n; i++) {
			System.out.print(arr[i] + "**");
		}
	}

	static void insertionSort(int[] arr) {
		for (int i = 1; i < arr.length; ++i) {
			for (int j = i; j > 0; j--) {
				if (arr[j] < arr[j - 1]) {
					int temp = arr[j];
					arr[j] = arr[j - 1];
					arr[j - 1] = temp;
				}
			}
		}
	}
}
