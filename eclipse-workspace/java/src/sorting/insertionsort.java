package sorting;

import java.util.Arrays;

public class insertionsort {
	public static void insertion(int arr[]) {
		int n = arr.length;
		for (int i = 1; i < n; ++i) {
			int key = arr[i];
			int j = i - 1;
			while (j >= 0 && arr[j] > key) {
				arr[j + 1] = arr[j];
				j = j - 1;
			}
			arr[j + 1] = key;
		}
	}

	public static void main(String[] args) {
		int arr[] = { 20, 50, 10, 30, 40 };
		System.out.println("Original Array: " + Arrays.toString(arr));
		insertion(arr);
		System.out.println("Sorted Array: " + Arrays.toString(arr));
	}
}
