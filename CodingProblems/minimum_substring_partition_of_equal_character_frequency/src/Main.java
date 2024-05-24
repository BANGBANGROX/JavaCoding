import java.util.Arrays;
import java.util.Scanner;

class Solution {
    private int[] dp;
    private String s;
    private int n;
    private final int INF = (int) 1e8;

    private boolean isBalanced(int[] count) {
        int maxValue = 0;
        int minValue = INF;

        for (int x : count) {
            if (x > 0) {
                maxValue = Math.max(maxValue, x);
                minValue = Math.min(minValue, x);
            }
        }

        return maxValue == minValue;
    }

    private int minimumSubstringsInPartitionHandler(int idx) {
        if (idx >= n) return 0;

        if (dp[idx] != -1) return dp[idx];

        int[] count = new int[26];
        int result = INF;

        for (int i = idx; i < n; ++i) {
            ++count[s.charAt(i) - 'a'];
            if (isBalanced(count)) {
                result = Math.min(result, minimumSubstringsInPartitionHandler(i + 1) + 1);
            }
        }

        return dp[idx] = result;
    }

    public int minimumSubstringsInPartition(String s) {
       this.s = s;
       n = s.length();
       dp = new int[n];

       Arrays.fill(dp, -1);

       return minimumSubstringsInPartitionHandler(0);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            String s = sc.next();

            System.out.println(new Solution().minimumSubstringsInPartition(s));
        }

        sc.close();
    }
}
