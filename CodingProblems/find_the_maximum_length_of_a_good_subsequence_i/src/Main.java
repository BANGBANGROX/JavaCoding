import java.util.Arrays;
import java.util.Scanner;

class Solution {
    private int[][][] dp;
    private int[] nums;
    private int k;
    private int n;

    private int maximumLengthHandler(int i, int last, int cnt) {
        if (i >= n) return 0;

        if (last == -1) {
            return Math.max(maximumLengthHandler(i + 1, last, cnt), maximumLengthHandler(i + 1, i, cnt) + 1);
        }

        if (dp[i][last][cnt] != -1) return dp[i][last][cnt];

        int result = maximumLengthHandler(i + 1, last, cnt);

        if (nums[i] == nums[last]) {
            result = Math.max(result, maximumLengthHandler(i + 1, i, cnt) + 1);
        } else if (cnt < k) {
            result = Math.max(result, maximumLengthHandler(i + 1, i, cnt + 1) + 1);
        }

        return dp[i][last][cnt] = result;
    }

    public int maximumLength(int[] nums, int k) {
        n = nums.length;
        this.k = k;
        this.nums = nums;
        dp = new int[n][n][k + 1];

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        return maximumLengthHandler(0, -1, 0);
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

            System.out.println(new Solution().maximumLength(nums, k));
        }

        sc.close();
    }
}
