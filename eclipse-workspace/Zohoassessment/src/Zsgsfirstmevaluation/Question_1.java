package Zsgsfirstmevaluation;

import java.util.Scanner;

public class Question_1 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter the Number = ");
			int n=sc.nextInt();
	        int[][] arr = new int[n][n];
	        int count=1;  
	        int a=0,c=n-1;
	        int b=0,d=n-1;
	        int t= (int) Math.pow(n,2);
	        for(int i=n-1;i>0;i--){
	            t = t -i;
	        }
	        while(count<t){
	            for(int i=a;i<=c;i++){
	                arr[i][b]=count;
	                count++;
	            }
	            b++;c--;
	            for(int i=c;i>=a;i--){
	                arr[i][d]=count;
	                count++;
	            }
	            d--;
	            for(int i=d;i>=b;i--){
	                arr[a][i]=count;
	                count++;
	            }
	            a++;c--;
	        }

	        for(int i=0;i<n;i++){
	            for(int s=0;s<i;s++){
	                System.out.print("  ");
	            }

	            for(int j=0;j<n;j++){
	                if(arr[i][j]==0)
	                    continue;
	                System.out.print(arr[i][j]+" ");
	            }
	            System.out.println();
	        }
		
	}
}