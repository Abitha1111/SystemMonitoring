package Batch5evaluation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class pairs {
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
