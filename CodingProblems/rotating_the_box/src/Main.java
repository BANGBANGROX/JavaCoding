import java.util.Scanner;

class Solution {
    private void reverse(char[] chars) {
        int left = 0;
        int right = chars.length - 1;

        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            ++left;
            --right;
        }
    }

    public char[][] rotateTheBox(char[][] box) {
        int m = box.length;
        int n = box[0].length;
        char[][] answer = new char[n][m];

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                answer[j][i] = box[i][j];
            }
        }

        for (char[] row : answer) {
            reverse(row);
        }

        for (int i = 0; i < m; ++i) {
            int lastRowWithEmptyCell = n - 1;
            for (int j = n - 1; j >= 0; --j) {
                if (answer[j][i] == '#') {
                    answer[j][i] = '.';
                    answer[lastRowWithEmptyCell][i] = '#';
                    --lastRowWithEmptyCell;
                } else if (answer[j][i] == '*') {
                    lastRowWithEmptyCell = j - 1;
                }
            }
        }

        return answer;
    }
}

public class Main {
   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           int m = scanner.nextInt();
           int n = scanner.nextInt();
           char[][] box = new char[m][n];
           for (int i = 0; i < m; ++i) {
               for (int j = 0; j < n; ++j) {
                   box[i][j] = scanner.next().charAt(0);
               }
           }

           char[][] answer = new Solution().rotateTheBox(box);
           for (char[] row : answer) {
               for (char x : row) {
                   System.out.print(x + " ");
               }
               System.out.println();
           }
           System.out.println();
       }
       
       scanner.close();
   }
}
