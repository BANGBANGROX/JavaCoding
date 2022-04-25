import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        int[] prefixSum = new int[n];
        int[] subArraysSum = new int[n * (n + 1) / 2];
        final int mod = (int)1e9 + 7;
        int ptr = 0;
        int ans = 0;

        prefixSum[0] = nums[0];
        --left;
        --right;

        for (int i = 1; i < n; ++i) {
            prefixSum[i] = (prefixSum[i - 1] + nums[i]) % mod;
        }

        for (int i = 0; i < n; ++i) {
            for (int j = i; j < n; ++j) {
                subArraysSum[ptr] = (prefixSum[j] - (i == 0 ? 0 : prefixSum[i - 1]) + mod) % mod;
                ++ptr;
            }
        }

        Arrays.sort(subArraysSum);

        for (int i = left; i <= right; ++i) {
            ans = (ans + subArraysSum[i]) % mod;
        }

        return ans;
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
            int left = sc.nextInt();
            int right = sc.nextInt();

            Solution solution = new Solution();
            System.out.println(solution.rangeSum(nums, n, left, right));
        }

        sc.close();
    }
}
