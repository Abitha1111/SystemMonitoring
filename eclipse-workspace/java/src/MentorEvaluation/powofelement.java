package MentorEvaluation;

import java.util.Scanner;

public class powofelement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of the array: ");
		int size = sc.nextInt();
		int[] arr = new int[size];
		System.out.println("Enter the elements of the array: ");
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		System.out.println("Enter the power : ");
		int power = sc.nextInt();
		for (int i = 0; i < arr.length; i++) {
			int result = 1;
			for (int j = 0; j < power; j++) {
				result *= arr[i];
			}
			arr[i] = result;
		}
		System.out.println("Powered Array :");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}















//Scanner sc = new Scanner(System.in);
//System.out.println("Enter the number :");
//int a = sc.nextInt();
//System.out.println("Enter the pow :");
//int b = sc.nextInt();
//int c = 1;
//for (int i = 0; i < b; i++) {
//	c = c * a;
//}
//System.out.println(c);
//}
//
//}
