import java.util.Arrays;
import java.util.Scanner;

class Solution {
    private static final int MOD = (int) 1e9 + 7;
    private static final int MAX_VALUE = 80;
    private int totalPermutations;
    private static final int[] factorial = new int[MAX_VALUE + 1];
    private static final int[] inverseFactorial = new int[MAX_VALUE + 1];
    private int[] count;
    private int[][][] dp;

    public Solution() {
        if (factorial[0] == 1) {
            return;
        }

        factorial[0] = inverseFactorial[0] = 1;

        for (int i = 1; i <= MAX_VALUE; ++i) {
            factorial[i] = multiply(factorial[i - 1], i);
            inverseFactorial[i] = computeInverse(factorial[i]);
        }
    }

    public int countBalancedPermutations(final String num) {
        final int n = num.length();
        int totalSum = 0;
        count = new int[10];

        for (final char ch : num.toCharArray()) {
            ++count[ch - '0'];
            totalSum += (ch - '0');
        }

        if ((totalSum & 1) > 0) {
            return 0;
        }

        dp = new int[10][42][42 * 9];
        totalPermutations = multiply(factorial[n / 2], factorial[n - n / 2]);

        for (int[][] x : dp) {
            for (int[] y : x) {
                Arrays.fill(y, -1);
            }
        }

        return dfs(0, n / 2, totalSum / 2);
    }

    private int dfs(final int currentDigit, final int digitsLeft, final int sumLeft) {
        if (currentDigit == 10) {
            if (sumLeft == 0 && digitsLeft == 0) return totalPermutations;
            return 0;
        }

        if (dp[currentDigit][digitsLeft][sumLeft] != -1) {
            return dp[currentDigit][digitsLeft][sumLeft];
        }

        final int upperBound = Math.min(digitsLeft,
                Math.min(count[currentDigit], (currentDigit > 0 ? sumLeft / currentDigit : Integer.MAX_VALUE)));
        long result = 0;

        for (int i = 0; i <= upperBound; ++i) {
            final int currentPermutations = multiply(inverseFactorial[i],
                    inverseFactorial[count[currentDigit] - i]);
            result = (result + multiply(currentPermutations, dfs(currentDigit + 1,
                    digitsLeft - i, sumLeft - i * currentDigit))) % MOD;
        }

        return dp[currentDigit][digitsLeft][sumLeft] = (int) result;
    }

    private int multiply(final long a, final long b) {
        return (int) (((a % MOD) * (b % MOD)) % MOD);
    }

    private int computeInverse(long a) {
        int power = MOD - 2;
        long result = 1;

        while (power > 0) {
            if ((power & 1) > 0) {
                result = multiply(result, a);
                --power;
            }
            a = multiply(a, a);
            power >>= 1;
        }

        return (int) result;
    }
}

public class Main {
   public static void main(String[] args) {
       final Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           System.out.println(new Solution().countBalancedPermutations(scanner.next()));
       }
       
       scanner.close();
   }
}
