package jul19;

import java.util.Scanner;

public class sumavg {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter the number of elements :");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int sum = 0;
		for (int i = 0; i < num; i++) {
			System.out.println("Enter the number" + (i + 1) + ":");
			sum += sc.nextInt();
		}
		int average = sum / num;
		System.out.println("sum :" + sum);
		System.out.println("average :" + average);
	}
}
