import java.util.Scanner;

class Solution {
    private String word;

    private int[] getCharCount(char[] word) {
        int[] count = new int[26];

        for (char ch : word) {
            if (ch >= 'a' && ch <= 'z') {
                ++count[ch - 'a'];
            }
        }

        return count;
    }

    private boolean filter(int[] rowCount, int[] wordCount) {
        for (int i = 0; i < 26; ++i) {
            if (rowCount[i] > wordCount[i]) return false;
        }

        return true;
    }

    private boolean checkOnRows(char[][] board) {
        for (char[] row : board) {
            int[] rowCount = getCharCount(row);
            int[] wordCount = getCharCount(word.toCharArray());

            if (!filter(rowCount, wordCount)) continue;

            int n = row.length;
            int leftPtr = 0;
            int rightPtr = word.length() - 1;
            int left = 0;
            int right = n  - 1;

            if (row[left] == ' ') {
                --wordCount[word.charAt(leftPtr) - 'a'];
                ++left;
                ++leftPtr;
            }

            if (row[right] == ' ') {
                --wordCount[word.charAt(rightPtr) - 'a'];
                --right;
                --rightPtr;
            }

            for (int i = left; i <= right && leftPtr <= rightPtr; ++i) {
                if (row[i] == '#') {
                    continue;
                }
                if (row[i] == word.charAt(leftPtr)) {
                    --wordCount[row[i] - 'a'];
                    --rowCount[row[i] - 'a'];
                    ++leftPtr;
                } else if (row[i] == ' ') {
                    if (rowCount[word.charAt(leftPtr) - 'a'] < wordCount[word.charAt(leftPtr) - 'a']) {
                        --wordCount[word.charAt(leftPtr) - 'a'];
                        ++leftPtr;
                    }
                }
            }
        }
    }

    public boolean placeWordInCrossword(char[][] board, String word) {
        // m - rows
        // n - cols
        // len - word length
        // m >= len -> check on rows
        // n >= len -> check on cols
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        while (testCases-- > 0) {
        }

        scanner.close();
    }
}
