import java.util.Scanner;

class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        int len = original.length;

        if (m * n != len) return new int[][]{};

        int[][] answer = new int[m][n];
        int itr = 0;

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                answer[i][j] = original[itr];
                ++itr;
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
           int len = scanner.nextInt();
           int[] original = new int[len];
           for (int i = 0; i < len; ++i) {
               original[i] = scanner.nextInt();
           }
           int m = scanner.nextInt();
           int n = scanner.nextInt();

           int[][] answer = new Solution().construct2DArray(original, m, n);
           for (int[] row : answer) {
               for (int x : row) {
                   System.out.print(x + " ");
               }
               System.out.println();
           }
           System.out.println();
       }
       
       scanner.close();
   }
}
