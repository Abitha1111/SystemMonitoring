package examplesums;

import java.util.Scanner;

public class pattern {

	public static void main(String[] args) {
		        Scanner scanner = new Scanner(System.in);

		        System.out.print("Enter a number: ");
		        int number = scanner.nextInt();

		        if (isJumbledNumber(number)) {
		            System.out.println(number + " is a jumbled number.");
		        } else {
		            System.out.println(number + " is not a jumbled number.");
		        }

//		        scanner.close();
		    }

		    static boolean isJumbledNumber(int num) 
		    {
		        // Convert the number to an array of digits
		        int[] digits = Integer.toString(num).chars().map(c -> c - '0').toArray();

		        // Check if the number is a jumbled number
		        for (int i = 0; i < digits.length - 1; i++) {
		            if (Math.abs(digits[i] - digits[i + 1]) != 1) {
		                return false;
		            }
		        }

		        return true;
		    }
		}