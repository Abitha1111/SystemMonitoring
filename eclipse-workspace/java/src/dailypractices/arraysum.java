package dailypractices;

import java.util.Arrays;

public class arraysum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
//		System.out.println(Arrays.toString(arr));
		System.out.println("Even Numbers");
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] % 2 == 0) {
				System.out.println(arr[i]);
			}
		}
			System.out.println("Odd Numbers");
			for (int j= 0; j < arr.length - 1; j++) {
				if (arr[j] % 2 != 0) {
					System.out.println(arr[j]);
				}
			}
		}
	}
