import java.util.Arrays;
import java.util.Scanner;

class Solution {
    private int[][] dp;
    private int k;
    private String s;
    private int n;

    private int getChanges(int left, int right) {
        int result = 0;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                ++result;
            }
            ++left;
            --right;
        }

        return result;
    }

    private int palindromePartitionHandler(int idx, int partitionCount) {
        if (idx >= n) {
            return partitionCount == k ? 0 : (int) 1e9;
        }

        if (dp[idx][partitionCount] != -1) return dp[idx][partitionCount];

        int result = (int) 1e9;

        for (int i = idx; i < n; ++i) {
            result = Math.min(result, getChanges(idx, i) + palindromePartitionHandler(i + 1, partitionCount + 1));
        }

        return dp[idx][partitionCount] = result;
    }

    public int palindromePartition(String s, int k) {
        this.s = s;
        this.k = k;
        n = s.length();
        dp = new int[n][n + 1];

        for (int i = 0; i < n; ++i) {
            Arrays.fill(dp[i], -1);
        }

        return palindromePartitionHandler(0, 0);
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        while (testCases-- > 0) {
            System.out.println(new Solution().palindromePartition(scanner.next(), scanner.nextInt()));
        }

        scanner.close();
    }
}
