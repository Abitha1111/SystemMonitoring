package DungeonGame;

import java.util.*;

public class Question_5 {

	static class Cell {
		int row, col;

		Cell(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Dimensions of the dungeon (Row x Column): ");
		int rows = sc.nextInt();
		int cols = sc.nextInt();

		System.out.print("Position of adventurer: ");
		int advR = sc.nextInt();
		int advC = sc.nextInt();

		System.out.print("Position of gold: ");
		int goldR = sc.nextInt();
		int goldC = sc.nextInt();

		System.out.print("Enter number of pits: ");
		int numPits = sc.nextInt();

		Set<Cell> pits = new HashSet<>();
		System.out.println("Position of pits:");
		for (int i = 0; i < numPits; i++) {
			System.out.print("Position of pit " + (i + 1) + ": ");
			int pitR = sc.nextInt();
			int pitC = sc.nextInt();
			pits.add(new Cell(pitR, pitC));
		}

		int minSteps = findMinimumSteps(rows, cols, advR, advC, goldR, goldC, pits);

		if (minSteps != -1) {
			System.out.println("Minimum number of steps: " + minSteps);
		} else {
			System.out.println("No possible solution");
		}
	}

	static int findMinimumSteps(int rows, int cols, int advR, int advC, int goldR, int goldC, Set<Cell> pits) {
		boolean[][] visited = new boolean[rows][cols];
		Queue<Cell> queue = new LinkedList<>();

		Cell adventurer = new Cell(advR, advC);
		Cell gold = new Cell(goldR, goldC);

		int[][] directions = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };
		queue.add(adventurer);
		visited[adventurer.row - 1][adventurer.col - 1] = true;

		int steps = 0;

		while (!queue.isEmpty()) {
			int size = queue.size();

			while (size-- > 0) {
				Cell current = queue.poll();

				if (current.row == gold.row && current.col == gold.col) {
					return steps;
				}

				for (int[] dir : directions) {
					int newRow = current.row + dir[0];
					int newCol = current.col + dir[1];

					Cell newCell = new Cell(newRow, newCol);

					if (isValidMove(rows, cols, newCell, visited, pits)) {
						queue.add(newCell);
						visited[newRow - 1][newCol - 1] = true;
					}
				}
			}
			steps++;
		}
		return -1; 
	}

	static boolean isValidMove(int rows, int cols, Cell cell, boolean[][] visited, Set<Cell> pits) {
		return cell.row >= 1 && cell.row <= rows && cell.col >= 1 && cell.col <= cols
				&& !visited[cell.row - 1][cell.col - 1] && !pits.contains(cell);
	}
}
