package Batch5evaluation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class sorting {
	public static List<String> countSort(List<Pair> arr) {
		// Get the maximum value from the list of integers
		int maxVal = Integer.MIN_VALUE;
		for (Pair pair : arr) {
			maxVal = Math.max(maxVal, pair.x);
		}

		// Create an array to store the count of each integer
		int[] count = new int[maxVal + 1];
		for (Pair pair : arr) {
			count[pair.x]++;
		}

		// Accumulate the count to determine the indices of the sorted array
		for (int i = 1; i <= maxVal; i++) {
			count[i] += count[i - 1];
		}

		// Create a list to store the sorted array
		List<String> result = new ArrayList<>(arr.size());
		for (int i = 0; i < arr.size(); i++) {
			result.add("");
		}
		for (int i = arr.size() - 1; i >= 0; i--) {
			Pair pair = arr.get(i);
			result.set(count[pair.x] - 1, pair.s);
			count[pair.x]--;
		}

		return result;
	}

	static class Pair {
		int x;
		String s;

		Pair(int x, String s) {
			this.x = x;
			this.s = s;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		List<Pair> arr = new ArrayList<>(n);
		for (int i = 0; i < n; i++) {
			int x = sc.nextInt();
			String s = sc.next();
			arr.add(new Pair(x, s));
		}
		sc.close();

		List<String> result = countSort(arr);
		for (String s : result) {
			System.out.print(s + " ");
		}
		System.out.println();
	}
}
