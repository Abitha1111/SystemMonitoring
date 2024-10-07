package Batch5evaluation;

import java.util.ArrayList;
import java.util.List;

public class subsetgenerator {
	public static List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> current = new ArrayList<>();
		ss(result, current, nums, 0);
		return result;
	}

	private static void ss(List<List<Integer>> result, List<Integer> current, int[] nums, int start) {
		result.add(new ArrayList<>(current));
		for (int i = start; i < nums.length; i++) {
			current.add(nums[i]);
			ss(result, current, nums, i + 1);
			current.remove(current.size() - 1);
		}
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3 };
		List<List<Integer>> subsets = subsets(nums);
		for (List<Integer> subset : subsets) {
			System.out.println(subset);
		}
	}
}
