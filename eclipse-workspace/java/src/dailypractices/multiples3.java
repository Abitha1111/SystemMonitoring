package dailypractices;

import java.util.Scanner;

public class multiples3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stud
//		Scanner scanner = new Scanner(System.in);
//		int testCases = scanner.nextInt();
//
//		for (int t = 0; t < testCases; t++) {
//			int num = scanner.nextInt();
//			long sum = 0;
//
//			for (int i = 1; i < num; i++) {
//				if (i % 3 == 0 || i % 5 == 0) {
//					sum += i;
//				}
//			}
//
//			System.out.println(sum);
//		}

		        Scanner sc = new Scanner(System.in);
		        int n = sc.nextInt();

		        for (int t = 1; t < n; t++) {
		            int num = sc.nextInt();
		            long sumOfMultiples = sumOfMultiples(num, 3) + sumOfMultiples(num, 5) - sumOfMultiples(num, 15);
		            System.out.println(sumOfMultiples);
		        }
		    }

		    public static long sumOfMultiples(int num, int multiple) {
		        int n = num / multiple;
		        int a = multiple;
		        return (long) n * (2 * a + (long) (n - 1) * multiple) / 2;
		    }
		}

	
