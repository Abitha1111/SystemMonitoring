package dailypractices;

import java.util.Scanner;

public class primeno {

	public static void main(String[] args) {
		// TODO Auto-generated method stud
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number :");
		int num = sc.nextInt();
		for (int i =100; i <= 999; i++) {
			boolean isPrime = true;
			for (int j = 2; j <= i / 2; j++) {
				if (i % j == 0) {
					isPrime = false;
					break;
				}
			}
			if (isPrime) {
				System.out.println(i + " ");
			}
		}
	}
}
