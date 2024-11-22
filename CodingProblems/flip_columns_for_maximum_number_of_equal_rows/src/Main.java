import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        Map<String, Integer> colsFlipCount = new HashMap<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int answer = 0;
        String maxCountCols = null;

        for (int[] row : matrix) {
            StringBuilder oneStringBuilder = new StringBuilder();
            StringBuilder zeroStringBuilder = new StringBuilder();
            for (int i = 0; i < n; ++i) {
                if (row[i] == 0) {
                    zeroStringBuilder.append(i).append('#');
                } else {
                    oneStringBuilder.append(i).append('#');
                }
            }
            if (!oneStringBuilder.isEmpty()) {
                String oneString = oneStringBuilder.toString();
                colsFlipCount.put(oneString,
                        colsFlipCount.getOrDefault(oneString, 0) + 1);
                if (maxCountCols == null ||
                        colsFlipCount.get(maxCountCols) < colsFlipCount.get(oneString)) {
                    maxCountCols = oneStringBuilder.toString();
                }
            }
            if (!zeroStringBuilder.isEmpty()) {
                String zeroString = zeroStringBuilder.toString();
                colsFlipCount.put(zeroStringBuilder.toString(),
                        colsFlipCount.getOrDefault(zeroString, 0) + 1);
                if (maxCountCols == null ||
                        colsFlipCount.get(maxCountCols) < colsFlipCount.get(zeroString)) {
                    maxCountCols = zeroStringBuilder.toString();
                }
            }
        }

        assert maxCountCols != null;
        String[] colsStrings = maxCountCols.split("#");

        for (String colsString : colsStrings) {
            if (!colsString.isEmpty()) {
                int col = Integer.parseInt(colsString);
                for (int i = 0; i < m; ++i) {
                    matrix[i][col] = 1 - matrix[i][col];
                }
            }
        }

        for (int[] row : matrix) {
            int first = row[0];
            boolean flag = true;
            for (int i = 1; i < n; ++i) {
                if (row[i] != first) {
                    flag = false;
                    break;
                }
            }
            if (flag) ++answer;
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
           int[][] matrix = new int[m][n];
           for (int i = 0; i < m; ++i) {
               for (int j = 0; j < n; ++j) {
                   matrix[i][j] = scanner.nextInt();
               }
           }

           System.out.println(new Solution().maxEqualRowsAfterFlips(matrix));
       }
       
       scanner.close();
   }
}
