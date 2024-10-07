package jul19;

import java.util.Scanner;

public class multiplies {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number");
		int n = sc.nextInt();
		int limit = 10;
		for (int i = 1; i <= limit; i++) {
			int result = n * i;
			System.out.println(n + " x " + i + " = " + result);
		}
	}

}
