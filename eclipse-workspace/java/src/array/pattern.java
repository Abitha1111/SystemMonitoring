package array;

import java.util.Scanner;

public class pattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the string:");
		String str = sc.nextLine();
		if (str.length() % 2 != 0) {

			for (int i = 0; i < str.length(); i++) {
				int k = str.length() - 1 - i;
				for (int j = 0; j < str.length(); j++) {
					if (j == i || k == j)
						System.out.print(str.charAt(j));
					else
						System.out.print(" ");
				}
				System.out.println(" ");
			}
		} else
			System.out.println(0);
	}
}
