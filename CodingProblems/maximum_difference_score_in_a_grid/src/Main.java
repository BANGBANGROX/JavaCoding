import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

class Solution {
    public int maxScore(List<List<Integer>> grid) {
        final int INF = (int) 1e9;
        int m = grid.size();
        int n = grid.get(0).size();
        int answer = -1 * INF;
        int[][] dp = new int[m][n];
        int[][] rowMax = new int[m][n];
        int[][] colMax = new int[n][m];
        int[][] dpAndRowMax = new int[m][n];
        int[][] dpAndColMax = new int[n][m];

        dp[m - 1][n - 1] = -1 * INF;
        rowMax[m - 1][n - 1] = grid.get(m - 1).get(n - 1);
        colMax[n - 1][m - 1] = grid.get(m - 1).get(n - 1);
        dpAndRowMax[m - 1][n - 1] = dp[m - 1][n - 1] + rowMax[m - 1][n - 1];
        dpAndColMax[n - 1][m - 1] = dp[m - 1][n - 1] + colMax[n - 1][m - 1];

        // Populating last column
        for (int i = m - 2; i >= 0; --i) {
            dp[i][n - 1] = Math.max(colMax[n - 1][i + 1], dpAndColMax[n - 1][i + 1]) - grid.get(i).get(n - 1);
            rowMax[i][n - 1] = grid.get(i).get(n - 1);
            colMax[n - 1][i] = Math.max(colMax[n - 1][i + 1], grid.get(i).get(n - 1));
            dpAndRowMax[i][n - 1] = dp[i][n - 1] + grid.get(i).get(n - 1);
            dpAndColMax[n - 1][i] = Math.max(dpAndColMax[n - 1][i + 1], dp[i][n - 1] + grid.get(i).get(n - 1));
            answer = Math.max(answer, dp[i][n - 1]);
        }

        // Populating last row
        for (int j = n - 2; j >= 0; --j) {
            dp[m - 1][j] = Math.max(rowMax[m - 1][j + 1], dpAndRowMax[m - 1][j + 1]) - grid.get(m - 1).get(j);
            rowMax[m - 1][j] = Math.max(rowMax[m - 1][j + 1], grid.get(m - 1).get(j));
            colMax[j][m - 1] = grid.get(m - 1).get(j);
            dpAndRowMax[m - 1][j] = Math.max(dpAndRowMax[m - 1][j + 1], dp[m - 1][j] + grid.get(m - 1).get(j));
            dpAndColMax[j][m - 1] = dp[m - 1][j] + grid.get(m - 1).get(j);
            answer = Math.max(answer, dp[m - 1][j]);
        }

        // Populating other rows and cols
        for (int i = m - 2; i >= 0; --i) {
            for (int j = n - 2; j >= 0; --j) {
                dp[i][j] = Math.max(rowMax[i][j + 1], Math.max(colMax[j][i + 1], Math.max(dpAndRowMax[i][j + 1], dpAndColMax[j][i + 1]))) - grid.get(i).get(j);
                rowMax[i][j] = Math.max(rowMax[i][j + 1], grid.get(i).get(j));
                colMax[j][i] = Math.max(colMax[j][i + 1], grid.get(i).get(j));
                dpAndRowMax[i][j] = Math.max(dpAndRowMax[i][j + 1], dp[i][j] + grid.get(i).get(j));
                dpAndColMax[j][i] = Math.max(dpAndColMax[j][i + 1], dp[i][j] + grid.get(i).get(j));
                answer = Math.max(answer, dp[i][j]);
            }
        }

        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            List<List<Integer>> grid = new ArrayList<>();
            for (int i = 0; i < m; ++i) {
                List<Integer> currentRow = new ArrayList<>();
                for (int j = 0; j < n; ++j) {
                    currentRow.add(sc.nextInt());
                }
                grid.add(new ArrayList<>(currentRow));
            }

            System.out.println(new Solution().maxScore(grid));
        }

        sc.close();
    }
}
