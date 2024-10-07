package jul19;

import java.util.Scanner;

public class fibonacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number:");
		int num = sc.nextInt();
		int num1 = 0;
		int num2;
		int num3 = 1;
		for (int i = 2; i < num; ++i)
			
		{
			num2 = num1 + num3;
			System.out.print(" " + num2);
			num1 = num3;
			num3 = num2;
		}
	}

}
