package Zsgssecondmevaluation;

import java.util.Scanner;

public class armstrong_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Number :");
		int num = sc.nextInt();
		int originalNumber;
		int remainder;
		int result = 0;
		int numLength = String.valueOf(num).length(); 
		originalNumber = num;
		while (originalNumber != 0) {
			remainder = originalNumber % 10;
			result += Math.pow(remainder, numLength);
			originalNumber /= 10;
		}
		if (result == num)
			System.out.println(num + " is an Armstrong number");
		else
			System.out.println(num + " is not an Armstrong number");
	}

}


