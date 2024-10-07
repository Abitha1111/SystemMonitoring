package DungeonGame;

import java.util.*;

public class Question_3 {

	static class Cell {
		int row;
		int col;

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

		System.out.print("Position of adventurer : ");
		int advR = sc.nextInt();
		int advC = sc.nextInt();

		System.out.print("Position of monster : ");
		int monsR = sc.nextInt();
		int monsC = sc.nextInt();

		System.out.print("Position of gold : ");
		int goldR = sc.nextInt();
		int goldC = sc.nextInt();

		List<Cell> path = new ArrayList<>();
		boolean[][] visited = new boolean[rows][cols];

		Queue<Cell> queue = new LinkedList<>();
		queue.add(new Cell(advR, advC));
		visited[advR - 1][advC - 1] = true;

		int[][] directions = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };

		Map<Cell, Cell> parent = new HashMap<>();
		Cell goldCell = null;

		while (!queue.isEmpty()) {
			Cell current = queue.poll();

			if (current.row == goldR && current.col == goldC) {
				goldCell = current;
				break;
			}

			for (int[] dir : directions) {
				int newRow = current.row + dir[0];
				int newCol = current.col + dir[1];

				if (newRow >= 1 && newRow <= rows && newCol >= 1 && newCol <= cols && !visited[newRow - 1][newCol - 1]
						&& !(newRow == monsR && newCol == monsC)) {
					Cell newCell = new Cell(newRow, newCol);
					queue.add(newCell);
					visited[newRow - 1][newCol - 1] = true;
					parent.put(newCell, current);
				}
			}
		}

		if (goldCell != null) {
			System.out.println("Minimum number of steps: " + calculateSteps(goldCell, parent));
			System.out.println("Path:");
			printPath(goldCell, parent);
		} else {
			System.out.println("No solution exists!");
		}
	}

	static int calculateSteps(Cell goldCell, Map<Cell, Cell> parent) {
		int steps = 0;
		Cell current = goldCell;

		while (parent.get(current) != null) {
			steps++;
			current = parent.get(current);
		}
		return steps;
	}

	static void printPath(Cell goldCell, Map<Cell, Cell> parent) {
		List<Cell> path = new ArrayList<>();
		Cell current = goldCell;

		while (current != null) {
			path.add(current);
			current = parent.get(current);
		}

		Collections.reverse(path);

		for (int i = 0; i < path.size(); i++) {
			Cell cell = path.get(i);
			System.out.print("(" + cell.row + "," + cell.col + ")");
			if (i != path.size() - 1) {
				System.out.print("->");
			}
		}
		System.out.println();
	}
}
