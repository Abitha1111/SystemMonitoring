package dailypractices;

import java.util.Scanner;

public class largestno {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int largest;
		System.out.println("Enter the first number :");
		int a = sc.nextInt();
		System.out.println("Enter the second number :");
		int b = sc.nextInt();
		System.out.println("Enter the third number :");
		int c = sc.nextInt();
		largest = c > (a > b ? a : b) ? c : (a > b ? a : b);
		System.out.println("The largest number is:" + largest);

	}

}
