package array;

import java.util.Scanner;

public class matrixmultiply {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	Scanner scanner = new Scanner(System.in);

		     System.out.print("Enter the number of rows for the first matrix: ");
		        int rowsA = scanner.nextInt();
		        System.out.print("Enter the number of columns for the first matrix: ");
		        int colsA = scanner.nextInt();

		        System.out.print("Enter the number of rows for the second matrix: ");
		        int rowsB = scanner.nextInt();
		        System.out.print("Enter the number of columns for the second matrix: ");
		        int colsB = scanner.nextInt();

		        if (colsA != rowsB) {
		            System.out.println("Matrix multiplication is not possible.");
		            return;
		        }

		        int[][] matrixA = new int[rowsA][colsA];
		        int[][] matrixB = new int[rowsB][colsB];

		        System.out.println("Enter elements of the first matrix:");
		        for (int i = 0; i < rowsA; i++) {
		            for (int j = 0; j < colsA; j++) {
		                matrixA[i][j] = scanner.nextInt();
		            }
		        }

		        System.out.println("Enter elements of the second matrix:");
		        for (int i = 0; i < rowsB; i++) {
		            for (int j = 0; j < colsB; j++) {
		                matrixB[i][j] = scanner.nextInt();
		            }
		        }

		        int[][] resultMatrix = new int[rowsA][colsB];

		        for (int i = 0; i < rowsA; i++) {
		            for (int j = 0; j < colsB; j++) {
		                for (int k = 0; k < colsA; k++) {
		                    resultMatrix[i][j] += matrixA[i][k] * matrixB[k][j];
		                }
		            }
		        }

		        System.out.println("Resultant matrix after multiplication:");
		        for (int i = 0; i < rowsA; i++) {
		            for (int j = 0; j < colsB; j++) {
		                System.out.print(resultMatrix[i][j] + " ");
		            }
		            System.out.println();
		        }

		        scanner.close();
		    }
		}
