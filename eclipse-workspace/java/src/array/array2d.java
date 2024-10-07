package array;

import java.util.Scanner;

public class array2d {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String arr[][] = { { "luke", "shaw" }, 
				{ "wayne", "rooney" }, 
				{ "rooney", "ronaldo" },
				{ "shaw", "rooney" } };
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the name:");
		String person=sc.nextLine();
        int count=0;
        for(String []target : arr)
        {
        	if(target[1].equals(person)) 
        	{
        		String child=target[0];
        		
        		for(String []subtarget : arr)
        		{
        			if(subtarget[1].equals(child))
        			{
        				
        				count++;
        			}
        		}
        	}
        }
        System.out.println("The number of grandchildren = " +  count);
	}
}