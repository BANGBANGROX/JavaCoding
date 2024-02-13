import java.util.Arrays;
import java.util.Scanner;

class Solution {
    private int[][] dp;
    private int[] nums1;
    private int[] nums2;
    private int m;
    private int n;

    private int maxDotProductUtil(int i, int j) {
        if (i >= m || j >= n) return Integer.MIN_VALUE;

        if (dp[i][j] != Integer.MIN_VALUE) return dp[i][j];

        return dp[i][j] = Math.max(nums1[i] * nums2[j] +
                Math.max(maxDotProductUtil(i + 1, j + 1), 0),
                Math.max(maxDotProductUtil(i + 1, j), maxDotProductUtil(i, j + 1)));
    }

    public int maxDotProduct(int[] nums1, int[] nums2) {
        m = nums1.length;
        n = nums2.length;
        dp = new int[m][n];
        this.nums1 = nums1;
        this.nums2 = nums2;

        for (int i = 0; i < m; ++i) {
            Arrays.fill(dp[i], Integer.MIN_VALUE);
        }

        return  maxDotProductUtil(0, 0);
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
            System.out.println(solution.maxDotProduct(nums1, nums2));
        }

        sc.close();
    }
}
