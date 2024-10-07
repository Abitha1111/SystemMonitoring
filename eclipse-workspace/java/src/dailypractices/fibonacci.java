package dailypractices;

import java.util.Scanner;

//import java.util.Scanner;

public class fibonacci {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number :");
		int n = sc.nextInt();
		int n1 = 0;
		int n2;
		int n3 = 1;
		for (int i = 2; i < n; ++i) {
			n2 = n1 + n3;
			System.out.print(" " + n2);
			n1 = n3;
			n3 = n2;
		}

	}
}
