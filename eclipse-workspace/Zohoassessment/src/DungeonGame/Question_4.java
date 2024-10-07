package DungeonGame;

import java.util.*;

public class Question_4 {

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

        System.out.print("Position of monster: ");
        int monsR = sc.nextInt();
        int monsC = sc.nextInt();

        System.out.print("Position of trigger: ");
        int trigR = sc.nextInt();
        int trigC = sc.nextInt();

        System.out.print("Position of gold: ");
        int goldR = sc.nextInt();
        int goldC = sc.nextInt();

        int minSteps = findMinimumSteps(rows, cols, advR, advC, monsR, monsC, trigR, trigC, goldR, goldC);

        System.out.println("Minimum number of steps: " + minSteps);
    }

    static int findMinimumSteps(int rows, int cols, int advR, int advC, int monsR, int monsC, int trigR, int trigC, int goldR, int goldC) {
        boolean[][] visited = new boolean[rows][cols];
        Queue<Cell> queue = new LinkedList<>();

        Cell adventurer = new Cell(advR, advC);
        Cell monster = new Cell(monsR, monsC);
        Cell trigger = new Cell(trigR, trigC);
        Cell gold = new Cell(goldR, goldC);

        int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
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

                    if (isValidMove(rows, cols, newCell, visited, monster, trigger)) {
                        queue.add(newCell);
                        visited[newRow - 1][newCol - 1] = true;
                    }
                }
            }
            steps++;
        }
        return -1; 
    }

    static boolean isValidMove(int rows, int cols, Cell cell, boolean[][] visited, Cell monster, Cell trigger) {
        return cell.row >= 1 && cell.row <= rows && cell.col >= 1 && cell.col <= cols
                && !visited[cell.row - 1][cell.col - 1] && !cell.equals(monster) && !cell.equals(trigger);
    }
}
