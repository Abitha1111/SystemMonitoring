package Batch5evaluation;

import java.io.*;
import java.util.ArrayList;

public class icecream {
	public static void main(String[] args) {
		int m = 6;
		int[] cost = { 1, 3, 4, 5, 6 };
		ArrayList<Integer> result = new ArrayList<Integer>();
		for (int i = 0; i < cost.length; i++) {
			for (int j = 0; j < cost.length; j++) {
				if (cost[i] + cost[j] == m) {
					result.add(i + 1);
					result.add(j + 1);
					break;
				}
			}
		}
		System.out.println(result);
	}

}