package examplesums;

import java.util.Scanner;

public class pyramid_4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println(" Enter the Number :");
		int a = sc.nextInt();
		for (int i = a; i >=1; i--) 
		{
			for (int k = 1; k<i; k++) 
			{
				System.out.print("  ");
			}
			for (int j = i; j <= a; j++) 
			{
				System.out.print(j+" ");
				}
			for(int l=a-1;l>=i;l--)
			{
				System.out.print(l+" ");
				
			}
			System.out.println();
	}

	}

}
