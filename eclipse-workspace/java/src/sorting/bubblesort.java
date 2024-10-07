package sorting;

import java.util.Arrays;

public class bubblesort {
	public static void bubble(int arr[]) {
		int temp;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 1; j < arr.length - i; j++) {
				if (arr[j - 1] > arr[j]) {
					temp = arr[j - 1];
					arr[j - 1] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 7,5,8,2,1 };
		System.out.println("Original Array :" + Arrays.toString(arr));
		bubble(arr);
		System.out.println("Sorted Array :" + Arrays.toString(arr));

	}

}
