import java.util.Arrays;
import java.util.Scanner;

class Solution {
    private long[][][][] dp;
    private final int MOD = (int) 1e9 + 7;

    private void initDp() {
        dp = new long[102][2][2][11];

        for (int i = 0; i < 102; ++i) {
            for (int j = 0; j < 2; ++j) {
                for (int k = 0; k < 2; ++k) {
                    Arrays.fill(dp[i][j][k], -1);
                }
            }
        }
    }

    private boolean checkString(String s) {
        for (int i = 1; i < s.length(); ++i) {
            if (Math.abs(s.charAt(i) - s.charAt(i - 1)) != 1) return false;
        }

        return true;
    }

    private long countSteppingNumbersHandler(int index, int toCompare, int isZero,
                                            int lastDigit, String s) {
        if (index == s.length()) {
            return isZero == 1 ? 0 : 1;
        }

        if (dp[index][toCompare][isZero][lastDigit + 1] != -1) {
            return dp[index][toCompare][isZero][lastDigit + 1];
        }

        int limit = 9;
        long result = 0;

        if (toCompare == 1) {
            limit = s.charAt(index) - '0';
        }

        for (int digit = 0; digit <= limit; ++digit) {
            int nextToCompare = toCompare;
            int nextIsZero = isZero;
            if (digit < limit) {
                nextToCompare = 0;
            }
            if (digit > 0) {
                nextIsZero = 0;
            }
            if (isZero == 1 || Math.abs(digit - lastDigit) == 1) {
                result = (result + countSteppingNumbersHandler(index + 1,
                        nextToCompare, nextIsZero, digit, s)) % MOD;
            }
        }

        return dp[index][toCompare][isZero][lastDigit + 1] = result;
    }

    public int countSteppingNumbers(String low, String high) {
        initDp();

        long firstValue = countSteppingNumbersHandler(0, 1, 1,
                -1, high);

        initDp();

        long secondValue = countSteppingNumbersHandler(0, 1, 1,
                -1, low);

        return (int) ((firstValue - secondValue + (checkString(low) ? 1 : 0) + MOD) % MOD);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            String low = sc.next();
            String high = sc.next();

            Solution solution = new Solution();
            System.out.println(solution.countSteppingNumbers(low, high));
        }

        sc.close();
    }
}
