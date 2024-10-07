package array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Q2sortarray {
		// TODO Auto-generated method stub
		    public static int calculateWeight(int num) {
		        int weight = 0;

		        if (isPerfectSquare(num)) {
		            weight += 5;
		        }
		        if (num % 4 == 0 && num % 6 == 0) {
		            weight += 4;
		        }
		        if (num % 2 == 0) {
		            weight += 3;
		        }

		        return weight;
		    }

		    public static boolean isPerfectSquare(int num) {
		        int sqrt = (int) Math.sqrt(num);
		        return sqrt * sqrt == num;
		    }

		    public static void main(String[] args) {
		        Scanner in = new Scanner(System.in);
		        System.out.println("Enter the length of the array you want:");
		        int len = in.nextInt();

		        System.out.println("Enter the values:");
		        int[] array = new int[len];
		        int[] weights = new int[len];

		        for (int i = 0; i < len; i++) {
		            array[i] = in.nextInt();
		            weights[i] = calculateWeight(array[i]);
		        }

		        // Sort the array based on weights in descending order.
			    
		        for (int i = 0; i < len; i++) {
		            for (int j = i + 1; j < len; j++) {
		                if (weights[i] < weights[j]) {
		                    int temp = weights[i];
		                    weights[i] = weights[j];
		                    weights[j] = temp;

					
		  // Swap corresponding values in the array as well.
		                    int tempValue = array[i];
		                    array[i] = array[j];
		                    array[j] = tempValue;
		                }
		            }
		        }

		        for (int i = 0; i < len; i++) {
		            System.out.print("<" + array[i] + ", " + weights[i] + "> ");
		        }
		    }
		}
	
