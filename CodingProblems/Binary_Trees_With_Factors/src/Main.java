import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

class Solution {
    public int numFactoredBinaryTrees(int[] nums) {
        int n = nums.length;
        long[] dp = new long[n];
        long ans = 0;
        final int MOD = (int)1e9 + 7;
        HashMap<Integer, Integer> numToIndex = new HashMap<>();

        Arrays.fill(dp, 1);
        Arrays.sort(nums);

        for (int i = 0; i < n; ++i) {
            numToIndex.put(nums[i], i);
        }

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                if (nums[i] % nums[j] == 0) {
                    int right = nums[i] / nums[j];
                    if (numToIndex.containsKey(right)) {
                        dp[i] = (dp[i] + (dp[j] * dp[numToIndex.get(right)]) % MOD) % MOD;
                    }
                }
            }
            ans = (ans + dp[i]) % MOD;
        }

        return (int)ans;
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
            System.out.println(solution.numFactoredBinaryTrees(nums));
        }

        sc.close();
    }
}
