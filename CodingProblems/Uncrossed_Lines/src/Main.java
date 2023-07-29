import java.util.Scanner;

class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
         int m = nums1.length;
         int n = nums2.length;
         int[][] dp = new int[m + 1][n + 1];

         for (int i = 1; i <= m; ++i) {
             for (int j = 1; j <= n; ++j) {
                 if (nums1[i - 1] == nums2[j - 1]) {
                     dp[i][j] = 1 + dp[i - 1][j - 1];
                 }
                 else {
                     dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                 }
             }
         }

         return dp[m][n];
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int m = sc.nextInt();
            int[] nums1 = new int[m];
            for (int i = 0; i < m; ++i) {
                nums1[i] = sc.nextInt();
            }
            int n = sc.nextInt();
            int[] nums2 = new int[n];
            for (int i = 0; i < n; ++i) {
                nums2[i] = sc.nextInt();
            }

            Solution solution = new Solution();
            System.out.println(solution.maxUncrossedLines(nums1, nums2));
        }

        sc.close();
    }
}
