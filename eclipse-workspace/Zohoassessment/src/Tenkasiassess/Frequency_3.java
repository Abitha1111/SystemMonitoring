package Tenkasiassess;

import java.util.Scanner;

public class Frequency_3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter a text:");
		String text = sc.nextLine();
		String[] words = text.replaceAll("[^a-zA-Z ]", "").toLowerCase().split(" ");
		String[] uniqueWords = new String[words.length];
		int[] frequencies = new int[words.length];
		int uniqueIndex = 0;
		for (String word : words) {
			boolean found = false;
			for (int i = 0; i < uniqueIndex; i++) {
				if (uniqueWords[i].equals(word)) {
					frequencies[i]++;
					found = true;
					break;
				}
			}
			if (!found) {
				uniqueWords[uniqueIndex] = word;
				frequencies[uniqueIndex] = 1;
				uniqueIndex++;
			}
		}
		for (int i = 0; i < uniqueIndex; i++) {
			System.out.println(uniqueWords[i] + ": " + frequencies[i] + " times");
		}
	}
}