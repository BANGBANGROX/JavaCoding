import java.util.Arrays;
import java.util.Scanner;

class Solution {
    private long[][] additionDp;
    private long[][] subtractionDp;
    private long[][] prefixMaxAdditionDp;
    private long[][] suffixMaxSubtractionDp;
    private int n;

    private void populatePrefixAndSuffix(int row) {
        // prefix populated for addition
        prefixMaxAdditionDp[row][0] = additionDp[row][0];

        for (int i = 1; i < n; ++i) {
            prefixMaxAdditionDp[row][i] = Math.max(prefixMaxAdditionDp[row][i - 1], additionDp[row][i]);
        }

        // suffix populated for subtraction
        suffixMaxSubtractionDp[row][n - 1] = subtractionDp[row][n - 1];

        for (int i = n - 2; i >= 0; --i) {
            suffixMaxSubtractionDp[row][i] = Math.max(suffixMaxSubtractionDp[row][i + 1], subtractionDp[row][i]);
        }
    }

    public long maxPoints(int[][] points) {
        int m = points.length;
        n = points[0].length;
        final long INF = (long) 1e12;
        long[][] dp = new long[m][n];
        additionDp = new long[m][n];
        subtractionDp = new long[m][n];
        prefixMaxAdditionDp = new long[m][n];
        suffixMaxSubtractionDp = new long[m][n];

        for (int i = 0; i < m; ++i) {
            Arrays.fill(dp[i], -1 * INF);
        }

        // 1. Initialise last row
        for (int j = 0; j < n; ++j) {
            dp[m - 1][j] = points[m - 1][j];
            additionDp[m - 1][j] = dp[m - 1][j] + j;
            subtractionDp[m - 1][j] = dp[m - 1][j] - j;
        }
        populatePrefixAndSuffix(m - 1);

        // 2. Populate other rows
        for (int i = m - 2; i >= 0; --i) {
            for (int j = 0; j < n; ++j) {
                long val = Math.max(prefixMaxAdditionDp[i + 1][j] - j, suffixMaxSubtractionDp[i + 1][j] + j) + points[i][j];
                dp[i][j] = Math.max(dp[i][j], val);
                additionDp[i][j] = dp[i][j] + j;
                subtractionDp[i][j] = dp[i][j] - j;
            }
            populatePrefixAndSuffix(i);
        }

        assert dp[0].length > 0;

        return Arrays.stream(dp[0]).max().getAsLong();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        while (testCases-- > 0) {
            int m = scanner.nextInt();
            int n = scanner.nextInt();
            int[][] points = new int[m][n];
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    points[i][j] = scanner.nextInt();
                }
            }

            System.out.println(new Solution().maxPoints(points));
        }
    }
}