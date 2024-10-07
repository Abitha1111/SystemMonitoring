package sorting;

import java.util.Arrays;

public class selectionsort {
	public static void selection(int arr[]) {
		int temp;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					temp = arr[j];
					arr[j] = arr[i];
					arr[i] = temp;
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 20, 50, 10, 30, 40 };
		System.out.println("Original Array :" + Arrays.toString(arr));
		selection(arr);
		System.out.println("Sorted Array :" + Arrays.toString(arr));

	}

}
