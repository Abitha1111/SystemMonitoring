         //input={1,2,3,4,5,6,7} output=4 5 3 6 2 7 1 
		// output={1,2,1,4,5,6,8,8} output=4 5 2 6 1 8 1 8




package array;
import java.util.Arrays;
import java.util.*;
import java.lang.*;
import java.util.Scanner;

public class rearrange {
			public static int[] findArray(int originalArray[], int  copyArray[],int len) {
				
				  int oddIndex = 0; 
				   int evenIndex = len - 1;
				    for(int i = len - 1; i >= 0; i--)
				    {
				      if(i % 2 != 0)
				      {
				    	  originalArray[i] = copyArray[evenIndex];
				       evenIndex --;
				      }
				      else{
				    	  originalArray[i] = copyArray[oddIndex];
				        oddIndex++;
				      }
				    }
				    
				    return  originalArray;
			}

			
			public static void main(String[] args)
			  {
				
				Scanner in=new Scanner(System.in);
				System.out.println("Enter the length:");
				int len=in.nextInt();
				
				System.out.println("Enter the values of the array:");
				
			    int[] originalArray=new int[len];
			    for(int i=0;i<len;i++) {
			    	originalArray[i]=in.nextInt();
			    }

			    int[] copyArray=new int[len];
			    
			    for(int i = 0; i < len; i++)
			    	 copyArray[i] = originalArray[i];
			 
			    Arrays.sort( copyArray);
			    
			    findArray(originalArray, copyArray,len);
			 
			    for(int i = 0; i < len; i++)
			    {
			      System.out.print(originalArray[i]+" ");
			    }
			  }
			}
	
