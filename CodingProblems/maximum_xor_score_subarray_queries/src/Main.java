import java.util.Scanner;

class Solution {
    public int[] maximumSubarrayXor(int[] nums, int[][] queries) {
        int q = queries.length;
        int n = nums.length;
        int[] answer = new int[q];
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; ++i) {
            dp[i][i] = nums[i];
        }

        for (int len = 2; len <= n; ++len) {
            for (int i = 0; i + len <= n; ++i) {
                int j = i + len - 1;
                dp[i][j] = dp[i + 1][j] ^ dp[i][j - 1];
            }
        }

        for (int len = 2; len <= n; ++len) {
            for (int i = 0; i + len <= n; ++i) {
                int j = i + len - 1;
                dp[i][j] = Math.max(dp[i][j], Math.max(dp[i + 1][j], dp[i][j - 1]));
            }
        }

        for (int i = 0; i < q; ++i) {
            answer[i] = dp[queries[i][0]][queries[i][1]];
        }

        return answer;
    }
}

public class Main {
   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           int n = scanner.nextInt();
           int[] nums = new int[n];
           for (int i = 0; i < n; ++i) {
               nums[i] = scanner.nextInt();
           }
           int q = scanner.nextInt();
           int[][] queries = new int[q][2];
           for (int i = 0; i < q; ++i) {
               queries[i][0] = scanner.nextInt();
               queries[i][1] = scanner.nextInt();
           }

           int[] answer = new Solution().maximumSubarrayXor(nums, queries);
           for (int x : answer) {
               System.out.print(x + " ");
           }
           System.out.println();
       }
       
       scanner.close();
   }
}
