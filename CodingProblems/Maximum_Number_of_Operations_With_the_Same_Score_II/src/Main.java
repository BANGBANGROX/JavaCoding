import java.util.Arrays;
import java.util.Scanner;

class Solution {
    private int[] nums;
    private int[][] dp;

    private void initDP() {
        for (int i = 0; i < nums.length; ++i) {
            Arrays.fill(dp[i], -1);
        }
    }

    private int maxOperationsHandler(int l, int r, int score) {
        if (r - l + 1 < 2) return 0;

        if (dp[l][r] != -1) return dp[l][r];

        int result = 0;

        if (nums[l] + nums[l + 1] == score) {
            result = Math.max(result, maxOperationsHandler(l + 2, r, score) + 1);
        }

        if (nums[l] + nums[r] == score) {
            result = Math.max(result, maxOperationsHandler(l + 1, r - 1 , score) + 1);
        }

        if (nums[r - 1] + nums[r] == score) {
            result = Math.max(result, maxOperationsHandler(l , r - 2, score) + 1);
        }

        return dp[l][r] = result;
    }

    public int maxOperations(int[] nums) {
        this.nums = nums;
        int n = nums.length;
        dp = new int[n][n];

        initDP();
        int answer = maxOperationsHandler(0, n - 1, nums[0] + nums[1]);

        initDP();
        answer = Math.max(answer, maxOperationsHandler(0, n - 1, nums[0] + nums[n - 1]));

        initDP();
        answer = Math.max(answer, maxOperationsHandler(0, n - 1, nums[n - 2] + nums[n - 1]));

        return answer;
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
            System.out.println(solution.maxOperations(nums));
        }

        sc.close();
    }
}


// [3, 2, 3, 2, 3, 2]