package dailypractices;

import java.util.Scanner;

public class reverseno {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Numbers");
		int n = sc.nextInt();
		int rem, rev = 0;
		while (n > 0) {
			rem = n % 10;
			rev = rev * 10 + rem;
			n = n / 10;
		}
		System.out.println("The reverse number is :" + rev);

	}

}
