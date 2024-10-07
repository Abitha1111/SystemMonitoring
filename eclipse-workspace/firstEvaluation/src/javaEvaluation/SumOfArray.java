package javaEvaluation;

import java.util.Scanner;

public class SumOfArray {
public static void main(String[] args) {
	

	        Scanner s = new Scanner(System.in);

	       
	        System.out.print("Number of digits for first number: ");
	        int digits1 = s.nextInt();
	        System.out.print("Enter first number: ");
	        String number1 = s.next();

	        
	        System.out.print("Number of digits for second number: ");
	        int digits2 = s.nextInt();
	        System.out.print("Enter second number: ");
	        String number2 = s.next();

	       
	        int[] numArray1 = toIntArray(number1, digits1);
	        int[] numArray2 = toIntArray(number2, digits2);

	     
	        int[] sumArray = addNumbers(numArray1, numArray2);

	      
	        System.out.print("Output: ");
	        for (int digit : sumArray) {
	            System.out.print(digit);
	        }

	    }


	    static int[] toIntArray(String number, int digits) {
	        int[] array = new int[digits];
	        for (int i = 0; i < digits; i++) {
	            array[i] = Character.getNumericValue(number.charAt(i));
	        }
	        return array;
	    }

	  
	    static int[] addNumbers(int[] num1, int[] num2) {
	        int maxLength = Math.max(num1.length, num2.length);
	        int[] result = new int[maxLength + 1];
	        int carry = 0;
	        for (int i = maxLength - 1; i >= 0; i--) {
	            int sum = carry;
	            if (i < num1.length) {
	                sum += num1[i];
	            }
	            if (i < num2.length) {
	                sum += num2[i];
	            }
	            result[i + 1] = sum % 10;
	            carry = sum / 10;
	        }
	        result[0] = carry;
	        return result;
	    }
	}
