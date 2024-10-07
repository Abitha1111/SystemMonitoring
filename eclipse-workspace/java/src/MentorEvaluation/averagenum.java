package MentorEvaluation;

import java.util.Scanner;

public class averagenum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of the array: ");
		int size = sc.nextInt();
		int[] arr = new int[size];
		System.out.println("Array Element is: ");
		for (int i = 0; i < size; i++) {
			arr[i] = sc.nextInt();
		}
		int sum = 0;
		for (int num : arr) {
			sum += num;
		}
		int average = sum / arr.length;
		int nearest = arr[0];
		int diff = nearest - average;
		if (diff < 0) {
			diff = -diff;
		}
		for (int i = 1; i < arr.length; i++) {
			int currentDiff = arr[i] - average;
			if (currentDiff < 0) {
				currentDiff = -currentDiff;
			}
			if (currentDiff < diff) {
				diff = currentDiff;
				nearest = arr[i];
			}
		}
		System.out.println("The element is: " + nearest);
	}
}
