package sorting;

import java.util.ArrayList;
import java.util.Arrays;

public class bucketsort {
	public static void Bucket(int arr[]) {
		int max = arr[0];
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > max) {
					max = arr[i];
				}
			}
		}

		ArrayList<Integer>[] Buckets = new ArrayList[max + 1];
		for (int k = 0; k < Buckets.length; k++) {
			Buckets[k] = new ArrayList<>();
		}
		for (int num : arr) {
			Buckets[num].add(num);
		}
		int index = 0;
		for (ArrayList<Integer> Bucket : Buckets) {
			for (int num : Bucket) {
				arr[index++] = num;
			}
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 3, 1, 9, 4, 8, 2, 5, 6, 7 };
		Bucket(arr);
		System.out.println(Arrays.toString(arr));

	}

}
