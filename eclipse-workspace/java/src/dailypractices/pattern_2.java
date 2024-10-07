package dailypractices;

import java.util.Scanner;

public class pattern_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number :");
		int n = sc.nextInt();
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (j <= n - i) {
					System.out.print("1"+" ");
				} else {
					System.out.print(i+" ");
				}
			}
			System.out.println();
		}
	}

}
