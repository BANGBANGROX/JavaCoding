import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Solution {
    private int[][] dp;
    private Map<Integer, Integer> requirementsMap;

    private int numberOfPermutationsHandler(int numsLeft, int currentInversions) {
        if (currentInversions < 0 || (requirementsMap.containsKey(numsLeft) && requirementsMap.get(numsLeft) != currentInversions)) return 0;

        if (numsLeft == 1) return currentInversions == 0 ? 1 : 0;

        if (dp[numsLeft][currentInversions] != -1) return dp[numsLeft][currentInversions];

        final int MOD = (int) 1e9 + 7;
        int result = 0;

        for (int i = 1; i <= numsLeft; ++i) {
            int inversionsUsed = numsLeft - i;
            result = (result + numberOfPermutationsHandler(numsLeft - 1, currentInversions - inversionsUsed)) % MOD;
        }

        return dp[numsLeft][currentInversions] = result;
    }

    public int numberOfPermutations(int n, int[][] requirements) {
        final int MAX_INVERSIONS = 405;
        requirementsMap = new HashMap<>();
        dp = new int[n + 1][MAX_INVERSIONS];

        for (int i = 0; i <= n; ++i) {
            Arrays.fill(dp[i], -1);
        }

        for (int[] requirement : requirements) {
            requirementsMap.put(requirement[0] + 1, requirement[1]);
        }

        return numberOfPermutationsHandler(n, requirementsMap.get(n));
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        while (testCases-- > 0) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int[][] requirements = new int[m][2];
            for (int i = 0; i < m; ++i) {
                requirements[i][0] = scanner.nextInt();
                requirements[i][1] = scanner.nextInt();
            }

            System.out.println(new Solution().numberOfPermutations(n, requirements));
        }
    }
}