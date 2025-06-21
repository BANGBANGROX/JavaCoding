import java.util.Scanner;

class Solution {
    private static final int MAX_VALUE = (int) 1e5 + 5;
    private static final int MOD = (int) 1e9 + 7;
    private static final long[] FACTORIAL = new long[MAX_VALUE];
    private static final long[] INVERSE_FACTORIAL = new long[MAX_VALUE];

    static {
        FACTORIAL[0] = 1;
        INVERSE_FACTORIAL[0] = 1;

        for (int i = 1; i < MAX_VALUE; ++i) {
            FACTORIAL[i] = calculateProduct(FACTORIAL[i - 1], i);
            INVERSE_FACTORIAL[i] = getModularInverse(FACTORIAL[i]);
        }
    }

    public int countGoodArrays(final int n, final int m, final int k) {
        return (int) calculateProduct(calculateNCR(n - 1, k),
                calculateProduct(m, calculatePower(m - 1, n - k - 1)));
    }

    private static long getModularInverse(final long val) {
        return calculatePower(val, MOD - 2);
    }

    private static long calculatePower(long a, int b) {
        long result = 1;

        while (b > 0) {
            if ((b & 1) > 0) {
                result = calculateProduct(result, a);
                --b;
            }
            a = calculateProduct(a, a);
            b >>= 1;
        }

        return result;
    }

    private static long calculateNCR(final int n, final int r) {
        if (r > n) {
            return 0;
        }

        return calculateProduct(FACTORIAL[n], calculateProduct(INVERSE_FACTORIAL[r], INVERSE_FACTORIAL[n - r]));
    }

    private static long calculateProduct(long a, long b) {
        return (a * b) % MOD;
    }
}

public class Main {
   public static void main(String[] args) {
       final Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           System.out.println(new Solution().countGoodArrays(scanner.nextInt(), scanner.nextInt(),
                   scanner.nextInt()));
       }
       
       scanner.close();
   }
}
