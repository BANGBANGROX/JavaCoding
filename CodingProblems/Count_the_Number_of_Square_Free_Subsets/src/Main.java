import java.util.Arrays;
import java.util.Scanner;

class Solution {
    private long[][] dp;
    private int[] nums;
    private int n;
    final int MOD = 1_000_000_007;

    private int getMask(int num) {
        int result = 0;
        int[] prime = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};

        for (int i = 0; i < prime.length; ++i) {
            if (num % prime[i] == 0) {
                num /= prime[i];
                if (num % prime[i] == 0) return -1;
                result |= (1 << (i + 1));
            }
        }

        return result;
    }

    private long squareFreeSubsetsUtil(int ind, int prodMask) {
        if (ind == n) return 1;

        if (dp[ind][prodMask] != -1) return dp[ind][prodMask];

        long result = squareFreeSubsetsUtil(ind + 1, prodMask);
        int mask = getMask(nums[ind]);

        if ((prodMask & mask) == 0) {
            result = (result + squareFreeSubsetsUtil(ind + 1,
                    prodMask | mask)) % MOD;
        }

        return dp[ind][prodMask] = result;
    }

    public int squareFreeSubsets(int[] nums) {
        this.nums = nums;
        n = nums.length;
        dp = new long[n][(1 << 11)];

        for (int i = 0; i < n; ++i) {
            Arrays.fill(dp[i], -1);
        }

        int ans = (int) squareFreeSubsetsUtil(0, 1);

        return (ans - 1 + MOD) % MOD;
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

            Solution solution = new Solution();
            System.out.println(solution.squareFreeSubsets(nums));
        }

        sc.close();
    }
}
