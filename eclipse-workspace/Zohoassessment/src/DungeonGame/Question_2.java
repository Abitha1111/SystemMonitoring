package DungeonGame;

import java.util.Scanner;

public class Question_2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Dimensions of the dungeon(Row x Column :  ");
		int row = sc.nextInt();
		int col = sc.nextInt();

		System.out.println("Position of Adventure : ");
		int advR = sc.nextInt();
		int advC = sc.nextInt();

		System.out.println("Position of Monster : ");
		int goldR = sc.nextInt();
		int goldC = sc.nextInt();

		System.out.println("Position of Gold : ");
		int monsR = sc.nextInt();
		int monsC = sc.nextInt();

		int steps = minimumMoves(row, col, advR, advC, goldR, goldC, monsR, monsC);

		if (steps == -1) {
			System.out.println("No Possible Solution");
		} else {
			System.out.println("Minimum number of steps : " + steps);
		}
	}

	private static int minimumMoves(int row, int col, int advR, int advC, int goldR, int goldC, int monsR, int monsC) {
		int advMoves = Moves(advR, advC, goldR, goldC);
		int monsterMoves = Moves(monsR, monsC, goldR, goldC);

		if (advMoves <= monsterMoves) {
			return advMoves;
		} else {
			return -1;
		}
	}

	private static int Moves(int startR, int startC, int destR, int destC) {
		int upMove = (startR > destR) ? (startR - destR) : (destR - startR);
		int downMove = (startC > destC) ? (startC - destC) : (destC - startC);

		return upMove + downMove;
	}
}
