package Zsgssecondmevaluation;

import java.util.Scanner;

public class pyramid_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println(" Enter the Number :");
		int num = sc.nextInt();
		for (int i = 1; i <= num; i++) {
			for (int k = num - i; k >= 1; k--) {
				System.out.print("  ");
			}
			for (int j = 1; j <= i; j++) {
				System.out.print(j + " ");
			}
			for (int l = i - 1; l >= 1; l--) {
				System.out.print(l + " ");

			}
			System.out.println();
		}
	}

}
