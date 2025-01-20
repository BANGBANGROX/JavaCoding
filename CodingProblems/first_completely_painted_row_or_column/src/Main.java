import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        Map<Integer, List<Integer>> matIndex = new HashMap<>();
        int m = mat.length;
        int n = mat[0].length;
        int[] rowCount = new int[m];
        int[] colCount = new int[n];

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                matIndex.put(mat[i][j], List.of(i, j));
            }
        }

        for (int i = 0; i < m * n; ++i) {
            int row = matIndex.get(arr[i]).getFirst();
            int col = matIndex.get(arr[i]).getLast();
            ++rowCount[row];
            ++colCount[col];
            if (rowCount[row] == n || colCount[col] == m) return i;
        }

        return -1;
    }
}

public class Main {
   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           int m = scanner.nextInt();
           int n = scanner.nextInt();
           int[] arr = new int[m * n];
           for (int i = 0; i < m * n; ++i) {
               arr[i] = scanner.nextInt();
           }
           int[][] mat = new int[m][n];
           for (int i = 0; i < m; ++i) {
               for (int j = 0; j < n; ++j) {
                   mat[i][j] = scanner.nextInt();
               }
           }

           System.out.println(new Solution().firstCompleteIndex(arr, mat));
       }
       
       scanner.close();
   }
}
