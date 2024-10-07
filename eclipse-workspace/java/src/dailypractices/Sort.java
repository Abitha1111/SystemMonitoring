package dailypractices;

import java.util.Scanner;

public class Sort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the array size :");
		int arraysize = sc.nextInt();
		int[] arr = new int[arraysize];
		System.out.println("Input array :");
		for (int i = 0; i < arraysize; i++) {
			arr[i] = sc.nextInt();
		}
		sortOddEven(arr);
		System.out.println("Output array :");
		for (int num : arr) {
			System.out.print(num + " ");
		}
	}

	private static void sortOddEven(int[] array) {
		// TODO Auto-generated method stub
		int oddnumcount = 0, evennumcount = 0;
		for (int num : array) {
			if (num % 2 != 0) {
				oddnumcount++;
			} else {
				evennumcount++;
			}
		}
		int[] oddnumbers = new int[oddnumcount];
		int[] evennumbers = new int[evennumcount];
		int oddindex = 0, evenindex = 0;
		for (int number : array) {
			if (number % 2 != 0) {
				oddnumbers[oddindex++] = number;
			} else {
				evennumbers[evenindex++] = number;
			}
		}
		for (int i = 0; i < oddnumbers.length - 1; i++) {
			for (int j = i + 1; j < oddnumbers.length; j++) {
				if (oddnumbers[i] < oddnumbers[j]) {
					int temp = oddnumbers[i];
					oddnumbers[i] = oddnumbers[j];
					oddnumbers[j] = temp;
				}
			}
		}
		for (int i = 0; i < evennumbers.length - 1; i++) {
			for (int j = i + 1; j < evennumbers.length; j++) {
				if (evennumbers[i] > evennumbers[j]) {
					int temp = evennumbers[i];
					evennumbers[i] = evennumbers[j];
					evennumbers[j] = temp;
				}
			}
		}
		int index = 0;
		for (int odd : oddnumbers) {
			array[index++] = odd;
		}
		for (int even : evennumbers) {
			array[index++] = even;
		}
	}
}
