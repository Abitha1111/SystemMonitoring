package sorting;
import java.util.Arrays;
import java.util.PriorityQueue;

public class heapsort {
			private static void heapsort(int[] arr) 
			{
				//using Priority queue 
				PriorityQueue<Integer> maxHeap=new PriorityQueue<>();
				//input all the element
				for(int i=0;i<arr.length;i++)
				{
					maxHeap.add(arr[i]);
				}
				
				
				System.out.println(maxHeap);
				// remove the last node
				
				for(int i=0;i<arr.length;i++)
				{
					arr[i]=maxHeap.poll(); 
//					9 8 7 5 3
				}
				System.out.println(Arrays.toString(arr));
				
				
				
			}


			public static void main(String[] args)
			{
				
				int arr[]= {5,3,8,9,7};
//				System.out.println("Before sorting: "+Arrays.toString(arr));
				heapsort.heapsort(arr);
				System.out.print("After Heapsorting: "+Arrays.toString(arr));		
//					
				

			}

			
		}
	
