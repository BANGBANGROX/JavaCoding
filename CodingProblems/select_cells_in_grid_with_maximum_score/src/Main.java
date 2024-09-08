import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class Solution {
    private int[][] dp;
    private List<List<Integer>> numIndices;

    private int maxScoreHandler(int num, int mask) {
        if (num <= 0) return 0;

        if (dp[num][mask] != -1) return dp[num][mask];

        int result = maxScoreHandler(num - 1, mask);

        for (int idx : numIndices.get(num)) {
            if ((mask & (1 << idx)) == 0) {
                result = Math.max(result, num + maxScoreHandler(num - 1, mask | (1 <<
                        idx)));
            }
        }

        return dp[num][mask] = result;
    }

    public int maxScore(List<List<Integer>> grid) {
        int m = grid.size();
        dp = new int[101][(1 << m) + 1];
        numIndices = new ArrayList<>();

        for (int[] innerDp : dp) {
            Arrays.fill(innerDp, -1);
            numIndices.add(new ArrayList<>());
        }

        for (int i = 0; i < m; ++i) {
            for (int val : grid.get(i)) {
                numIndices.get(val).add(i);
            }
        }

        return maxScoreHandler(100, 0);
    }
}

public class Main {
   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           int m = scanner.nextInt();
           int n = scanner.nextInt();
           List<List<Integer>> grid = new ArrayList<>();

           for (int i = 0; i < m; ++i) {
               grid.add(new ArrayList<>());
               for (int j = 0; j < n; ++j) {
                   grid.get(i).add(scanner.nextInt());
               }
           }

           System.out.println(new Solution().maxScore(grid));
       }
       
       scanner.close();
   }
}
