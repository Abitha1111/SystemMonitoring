package jul19;

import java.util.Scanner;

public class reversenum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter the number :");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int rem, rev = 0;
		while (num > 0) {
			rem = num % 10;
			rev = rev * 10 + rem;
			num = num / 10;
		}
		System.out.println("Reverse number is :" + rev);

	}

}
