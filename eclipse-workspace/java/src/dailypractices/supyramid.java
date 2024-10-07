package dailypractices;

import java.util.Scanner;

public class supyramid {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the String :");
		String str = sc.next();

		int index = 0;
		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i) >= 65 && str.charAt(i) <= 92) {
				index = i;
			}
		}
		int temp = index;
		for (int i = 0; i < index; i++) {
			for (int j = 0; j < 1; j++) {
				for (int k = 0; k <= i; k++) {
					if (index >= i && index != k) {
						System.out.print(Character.toUpperCase(str.charAt(k)));
					}
				}
				for (int l = 0; l <= i; l++) {
					if (index < str.length()) {
						System.out.print(Character.toUpperCase(str.charAt(index++)));
					}
				}
			}
			index = temp;
			System.out.println();
		}
	}
}
