package Zsgssecondmevaluation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class array_3 {
	public static List<List<Integer>> divisiblePairs(int[] arr, int k) {
		Map<Integer, List<Integer>> map = new HashMap<>();
		List<List<Integer>> result = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			int complement = k - arr[i] % k;
			if (map.containsKey(complement)) {
				for (int index : map.get(complement)) {
					result.add(List.of(arr[index], arr[i]));
				}
			}
			map.computeIfAbsent(arr[i] % k, x -> new ArrayList<>()).add(i);
		}
		return result;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6 };
		int k = 5;
		List<List<Integer>> pairs = divisiblePairs(arr, k);
		for (List<Integer> pair : pairs) {
			System.out.println(pair);
		}
	}
}





















//public class array_3 
//{		
//			public static void divisiblePairs(int[] arr, int k) {
//		        for (int i = 0; i < arr.length; i++) {
//		            for (int j = i + 1; j < arr.length; j++) {
//		                if ((arr[i] + arr[j]) % k == 0) {
//		                    System.out.println("(" + arr[i] + ", " + arr[j] + ")");
//		                }
//		            }
//		        }
//		    }
//
//		    public static void main(String[] args) {
//		        int[] arr = { 1, 2, 3, 4, 5, 6 };
//		        int k = 5;
//		        divisiblePairs(arr, k);
//		    }
//		}