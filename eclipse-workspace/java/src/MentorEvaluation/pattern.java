package MentorEvaluation;

import java.util.Scanner;

public class pattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the value : ");
		int value = sc.nextInt();
		for (int i = 0; i < 2 * value - 1; i++) {
			for (int j = 0; j < 2 * value - 1; j++) {
				int x = i < 2 * value - i - 1 ? i : 2 * value - i - 2;
				int y = j < 2 * value - j - 1 ? j : 2 * value - j - 2;
				int min = x < y ? x : y;
				int num = value - min;
				System.out.print(num + " ");
			}
			System.out.println();
		}
	}
}
