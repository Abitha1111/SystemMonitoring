package CommonMentorQuestions;

import java.util.HashSet;
import java.util.Set;

public class dictionaryString {
    
    public static void findWords(char[][] grid, Set<String> dictionary) {
        int rows = grid.length;
        int cols = grid[0].length;

        for (String word : dictionary) {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (searchWord(grid, i, j, word)) {
                        System.out.println(word);
                    }
                }
            }
        }
    }

    public static boolean searchWord(char[][] grid, int row, int col, String word) {
        int rows = grid.length;
        int cols = grid[0].length;
        int len = word.length();

        // Check if word fits horizontally starting from (row, col)
        if (col + len <= cols) {
            StringBuilder horizontal = new StringBuilder();
            for (int k = 0; k < len; k++) {
                horizontal.append(grid[row][col + k]);
            }
            if (horizontal.toString().equals(word)) {
                return true;
            }
        }

        // Check if word fits vertically starting from (row, col)
        if (row + len <= rows) {
            StringBuilder vertical = new StringBuilder();
            for (int k = 0; k < len; k++) {
                vertical.append(grid[row + k][col]);
            }
            if (vertical.toString().equals(word)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        char[][] grid = {
            {'a', 'z', 'o', 'l'},
            {'n', 'x', 'h', 'o'},
            {'v', 'y', 'i', 'v'},
            {'o', 'r', 's', 'e'}
        };

        Set<String> dictionary = new HashSet<>();
        dictionary.add("van");
        dictionary.add("zoho");
        dictionary.add("love");
        dictionary.add("are");
        dictionary.add("is");

        findWords(grid, dictionary);
    }
}

