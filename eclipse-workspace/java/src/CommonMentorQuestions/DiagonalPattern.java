package CommonMentorQuestions;
import java.util.Scanner;

public class DiagonalPattern {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the String: ");
        String input = scanner.nextLine();

        if (input.length() % 2 != 0) {
            displayDiagonalPattern(input);
        } else {
            System.out.println("Not Possible");
        }

        scanner.close();
    }

    private static void displayDiagonalPattern(String str) {
        int length = str.length();
        int mid = length / 2;

        // Printing the upper half of the pattern
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (j == mid - i || j == mid + i || (i > mid && j == i - mid) || (i > mid && j == length - i + mid - 1)) {
                    System.out.print(str.charAt(mid));
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        // Printing the lower half of the pattern
        for (int i = length - 2; i >= 0; i--) {
            for (int j = 0; j < length; j++) {
                if (j == mid - i || j == mid + i || (i > mid && j == i - mid) || (i > mid && j == length - i + mid - 1)) {
                    System.out.print(str.charAt(mid));
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
