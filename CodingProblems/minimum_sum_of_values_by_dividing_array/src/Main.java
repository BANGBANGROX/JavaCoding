import java.util.HashMap;
import java.util.Scanner;

class Solution {
    private int[] nums;
    private int[] andValues;
    private int m;
    private int n;
    private HashMap<Integer, Integer>[][] dp;
    private final int INF = (int) 1e8;
    private final int FULL_MASK = (1 << 20) - 1;

    private int minimumValueSumHandler(int i, int j, int currentAndValue) {
        if (i >= m) {
            return j >= n ? 0 : INF;
        }

        if (j >= n) return INF;

        if (dp[i][j] == null) {
            dp[i][j] = new HashMap<>();
        }

        if (dp[i][j].containsKey(currentAndValue)) return dp[i][j].get(currentAndValue);

        int result = minimumValueSumHandler(i + 1, j, currentAndValue & nums[i]);

        if ((currentAndValue & nums[i]) == andValues[j]) {
            result = Math.min(result, nums[i] + minimumValueSumHandler(i + 1, j + 1, FULL_MASK));
        }

        dp[i][j].put(currentAndValue, result);

        return result;
    }

    public int minimumValueSum(int[] nums, int[] andValues) {
        this.nums = nums;
        this.andValues = andValues;
        m = nums.length;
        n = andValues.length;
        dp = new HashMap[m][n];
        int result = minimumValueSumHandler(0, 0, FULL_MASK);

        return result >= INF ? -1 : result;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int m = sc.nextInt();
            int[] nums = new int[m];
            for (int i = 0; i < m; ++i) {
                nums[i] = sc.nextInt();
            }
            int n = sc.nextInt();
            int[] andValues = new int[n];
            for (int i = 0; i < n; ++i) {
                andValues[i] = sc.nextInt();
            }

            Solution solution = new Solution();
            System.out.println(solution.minimumValueSum(nums, andValues));
        }

        sc.close();
    }
}
