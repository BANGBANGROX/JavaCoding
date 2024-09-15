import java.util.Arrays;
import java.util.Scanner;

class Solution {
    private int[][][][] dp;
    private int n;

    private int stringCountHandler(int idx, int lRemaining, int eRemaining,
                                   int tRemaining) {
        if (idx >= n) {
            return lRemaining == 0 && eRemaining == 0 && tRemaining == 0 ? 1 : 0;
        }

        if (dp[idx][lRemaining][eRemaining][tRemaining] != -1) {
            return dp[idx][lRemaining][eRemaining][tRemaining];
        }

        final int MOD = (int) 1e9 + 7;
        int withoutLEAndT = stringCountHandler(idx + 1, lRemaining, eRemaining,
                tRemaining);
        int withL = stringCountHandler(idx + 1, Math.max(lRemaining - 1, 0), eRemaining, tRemaining);
        int withE = stringCountHandler(idx + 1, lRemaining, Math.max(eRemaining - 1, 0), tRemaining);
        int withT = stringCountHandler(idx + 1, lRemaining, eRemaining, Math.max(tRemaining - 1, 0));
        long result = ((long) 23 * withoutLEAndT + withL + withE + withT) % MOD;

        return dp[idx][lRemaining][eRemaining][tRemaining] = (int) result;
    }

    public int stringCount(int n) {
        dp = new int[n][2][3][2];
        this.n = n;

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < 2; ++j) {
                for (int k = 0; k < 3; ++k) {
                    Arrays.fill(dp[i][j][k], -1);
                }
            }
        }

        return stringCountHandler(0, 1, 2, 1);
    }
}

public class Main {
   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           System.out.println(new Solution().stringCount(scanner.nextInt()));
       }
       
       scanner.close();
   }
}
