package dailypractices;

import java.util.Scanner;

public class pattern_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number:");
		int pa = sc.nextInt();
		for (int i = 1; i <= pa; i++) {
			for (int j = 1; j <= i; j++) {
				if (j == 2) {
					System.out.print(i + (pa - 1) + " ");
				} else if (j == 3) {
					System.out.print(i + (pa + 2) + " ");
				} else if (j == 4) {
					System.out.print(i + (pa + 4) + " ");
				} else if (j == 5) {
					System.out.print(i + (pa + 5) + " ");
				} else {

					System.out.print(i + " ");
				}
			}
			System.out.println();
		}
	}
}