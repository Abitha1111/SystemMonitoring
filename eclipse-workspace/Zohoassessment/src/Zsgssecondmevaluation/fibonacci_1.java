package Zsgssecondmevaluation;

import java.util.Scanner;

public class fibonacci_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number :");
		int n = sc.nextInt();
            int[] fibonacci = new int[n];
            fibonacci[0] = 0;
            fibonacci[1] = 1;
            for (int i = 2; i < n; i++) {
                fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
            }
            System.out.println("Reverse Fibonacci series is" );
            for (int i = n - 1; i >= 0; i--) {
                System.out.print(fibonacci[i] + " ");
            }
        }
	}

