package DungeonGame;

import java.util.Scanner;

public class Question_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stud
		Scanner sc = new Scanner(System.in);

		System.out.println("Dimensions of the dungeon (Row x Column):");
		int rows = sc.nextInt();
		int cols = sc.nextInt();

		System.out.println("Position of adventurer :");
		int adv1 = sc.nextInt();
		int adv2 = sc.nextInt();
		
		System.out.println("Position of monster (x y):");
		int monX = sc.nextInt();
		int monY = sc.nextInt();

		System.out.println("Position of gold :");
		int gold1 = sc.nextInt();
		int gold2 = sc.nextInt();
		int steps = Math.abs(adv1 - gold1) + Math.abs(adv2 - gold2);
		System.out.println("Minimum number of steps: " + steps);
		while (adv1 != gold1 || adv2 != gold2) {
			if (adv1 < gold1) {
				adv1++;
			} else if (adv1 > gold1) {
				adv1--;
			} else if (adv2 < gold2) {
				adv2++;
			} else if (adv2 > gold2) {
				adv2--;
			}
		}
	}
}
