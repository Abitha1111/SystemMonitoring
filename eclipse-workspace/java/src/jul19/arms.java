package jul19;

import java.util.Scanner;

public class arms {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter the number :");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int sum = 0;
		int orgnum = num;
		int temp;
		while (num > 0) {
			temp = num % 10;
			sum = sum + (temp * temp * temp);
			num = num / 10;
		}

		if (orgnum == sum) {
			System.out.println("is a armstrong number");
		} else {
			System.out.println("is not a armstrong number");
		}

	}

}
