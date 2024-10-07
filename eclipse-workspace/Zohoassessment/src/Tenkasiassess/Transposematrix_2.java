package Tenkasiassess;

import java.util.Scanner;

public class Transposematrix_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number of rows: ");
		int rows = sc.nextInt();
		System.out.print("Enter the number of columns: ");
		int columns = sc.nextInt();
		int[][] matrix = new int[rows][columns];
		System.out.println("Enter the matrix elements:");
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				matrix[i][j] = sc.nextInt();
			}
		}

		int[][] transposedMatrix = new int[columns][rows];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				transposedMatrix[j][i] = matrix[i][j];
			}
		}

		System.out.println("Original Matrix:");
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}

		System.out.println("Transposed Matrix:");
		for (int i = 0; i < columns; i++) {
			for (int j = 0; j < rows; j++) {
				System.out.print(transposedMatrix[i][j] + " ");
			}
			System.out.println();
		}
	}

}
