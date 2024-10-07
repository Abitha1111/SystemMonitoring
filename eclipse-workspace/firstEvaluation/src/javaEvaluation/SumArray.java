package javaEvaluation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SumArray {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the array size :");
		int size = s.nextInt();

		int[] array = new int[size];
		System.out.println("Enter the array elements :");
		for (int i = 0; i < size; i++) {
			array[i] = s.nextInt();
		}

		int maxSum = Integer.MIN_VALUE;
		int curSum = 0;
		List<Integer> curSubarray = new ArrayList<>();
		List<Integer> maxSubarray = new ArrayList<>();

		for (int num : array) {
			if (num >= 0) {
				curSum += num;
				curSubarray.add(num);
				if (curSum > maxSum) {
					maxSum = curSum;
					maxSubarray = new ArrayList<>(curSubarray);
				}
			} else {
				curSum = 0;
				curSubarray.clear();
			}
		}

		System.out.println("Sum: " + maxSum);
		System.out.print("Elements: ");
		for (int i = 0; i < maxSubarray.size(); i++) {
			System.out.print(maxSubarray.get(i));
			if (i < maxSubarray.size() - 1) {
				System.out.print(", ");
			}
		}
		System.out.println();
	}
}
