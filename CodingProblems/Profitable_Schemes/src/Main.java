import java.util.Arrays;
import java.util.Scanner;

class Solution {
    private int[][][] dp;
    private int[] group;
    private int[] profit;
    private int totalNumberOfCrimes;
    private int minProfit;

    private int calculateProfit(int crimeIndex, int membersLeft, int profitGenerated) {
        int MOD = 1_000_000_007;
        if (membersLeft < 0) return 0;

        if (crimeIndex >= totalNumberOfCrimes) return profitGenerated >= minProfit ? 1 : 0;

        if (dp[crimeIndex][membersLeft][profitGenerated] != -1)
            return dp[crimeIndex][membersLeft][profitGenerated];

        int answer = (calculateProfit(crimeIndex + 1,
                membersLeft - group[crimeIndex],
                profitGenerated + profit[crimeIndex]) +
                calculateProfit(crimeIndex + 1, membersLeft, profitGenerated)) % MOD;

        return dp[crimeIndex][membersLeft][profitGenerated] = answer;
    }

    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        totalNumberOfCrimes = group.length;
        dp = new int[totalNumberOfCrimes][n + 1][minProfit + 1000];
        this.group = group;
        this.profit = profit;
        this.minProfit = minProfit;

        for (int i = 0; i < totalNumberOfCrimes; ++i) {
            for (int j = 0; j <= n; ++j) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        return calculateProfit(0, n, 0);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            int minProfit = sc.nextInt();
            int m = sc.nextInt();
            int[] group = new int[m];
            int[] profit = new int[m];
            for (int i = 0; i < m; ++i) {
                group[i] = sc.nextInt();
            }
            for (int i = 0; i < m; ++i) {
                profit[i] = sc.nextInt();
            }

            Solution solution = new Solution();
            System.out.println(solution.profitableSchemes(n, minProfit, group, profit));
        }

        sc.close();
    }
}
