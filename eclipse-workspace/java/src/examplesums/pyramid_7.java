package examplesums;

import java.util.Scanner;

public class pyramid_7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println(" Enter the Number :");
		int a = sc.nextInt();
		for (int i = 1; i <= a; i++) {
			int b=1;
			for (int k = a - i; k >= 1; k--) {
				System.out.print(" ");
			}
			for (int j = 1; j <= i; j++) {
				System.out.print(b+ " ");
				b++;
			}
			System.out.println();
		}
	}

}
