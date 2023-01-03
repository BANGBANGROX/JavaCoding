import java.util.Arrays;
import java.util.Scanner;

class Solution {
    private int[] nums;
    private long[] power;
    private long[][] dp1;
    private long[][] dp2;
    private final int MOD = (int) 1e9 + 7;
    private int n;
    private int k;

    private void init(int[] nums, int k) {
        this.nums = nums;
        this.k = k;
        n = nums.length;
        dp1 = new long[n][k + 1];
        dp2 = new long[n][k + 1];
        power = new long[n + 1];

        for (int i = 0; i < n; ++i) {
            Arrays.fill(dp1[i], -1);
            Arrays.fill(dp2[i], -1);
        }

        power[0] = 1;

        for (int i = 1; i <= n; ++i) {
            power[i] = (power[i - 1] * 2) % MOD;
        }
    }

    private long countPartitionsUtil(int idx, long group1Sum, long group2Sum) {
        if (idx >= n) {
            if (group1Sum >= k && group2Sum >= k) return 1;
            return 0;
        }

        if (group1Sum >= k && group2Sum >= k) return power[n - idx];

        if (group1Sum <= k && dp1[idx][(int) group1Sum] != -1)
            return dp1[idx][(int) group1Sum];

        if (group2Sum <= k && dp2[idx][(int) group2Sum] != -1)
            return dp2[idx][(int) group2Sum];

        long ans = (countPartitionsUtil(idx + 1, group1Sum + nums[idx], group2Sum) +
                countPartitionsUtil(idx + 1, group1Sum, group2Sum
                        + nums[idx])) % MOD;

        if (group1Sum <= k) return dp1[idx][(int) group1Sum] = ans;

        return dp2[idx][(int) group2Sum] = ans;
    }

    public int countPartitions(int[] nums, int k) {
         init(nums, k);

         return (int) countPartitionsUtil(0, 0, 0);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; ++i) {
                nums[i] = sc.nextInt();
            }
            int k = sc.nextInt();

            Solution solution = new Solution();
            System.out.println(solution.countPartitions(nums, k));
        }

        sc.close();
    }
}
