import java.util.Arrays;
import java.util.Scanner;

class Solution {
    private int[][] dp;
    private int n;

    private int minStepsHandler(int currentLength, int copiedLength) {
        final int INF = (int) 1e9;

        if (currentLength == n)
            return 0;

        if (dp[currentLength][copiedLength] != -1)
            return dp[currentLength][copiedLength];

        int result = INF;

        // COPY
        if (copiedLength < currentLength) {
            result = Math.min(result, minStepsHandler(currentLength, currentLength) + 1);
        }

        // PASTE
        if (copiedLength > 0 && currentLength + copiedLength <= n) {
            result = Math.min(result, minStepsHandler(currentLength + copiedLength, copiedLength) + 1);
        }

        return dp[currentLength][copiedLength] = result;
    }

    public int minSteps(int n) {
        this.n = n;
        dp = new int[2 * n][2 * n];

        for (int i = 0; i < 2 * n; ++i) {
            Arrays.fill(dp[i], -1);
        }

        return minStepsHandler(1, 0);
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        while (testCases-- > 0) {
            System.out.println(new Solution().minSteps(scanner.nextInt()));
        }

        scanner.close();
    }
}
