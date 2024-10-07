package dailypractices;

import java.util.Scanner;

public class NumberToWords {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number :");
		int n = sc.nextInt();
		int num[] = new int[n];
		for (int i = 0; i < n; i++) {
			num[i] = sc.nextInt();
		}
		for (int number : num) {
			int a = number % 10;
			int b = number / 10;
			int c = b % 10;
			int g = number / 100;
			int d = g % 10;
			int e = number / 1000;
			String[] s = { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven",
					"Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen" };
			String[] ty = { "", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety" };
			String h = "Hundred";
			String th = "Thousand";
			if (number < 20) {
				System.out.println(s[number]);
			} else if ((number >= 20) && (number < 100)) {
				System.out.println(ty[c] + " " + s[a]);
			} else if ((number >= 100) && (number <= 999)) {
				System.out.println(s[g] + " " + h + " " + ty[c] + " " + s[a]);
			} else {
				System.out.println(s[e] + " " + th + " " + s[d] + " " + h + " " + ty[c] + " " + s[a]);
			}
		}
	}
}
