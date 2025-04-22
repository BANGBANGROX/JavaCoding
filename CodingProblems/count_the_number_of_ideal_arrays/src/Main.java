import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution {
    private static final int MAX_VALUE = 10010;
    private static final int MAX_PRIME_FACTORS = 15;
    private static final List<List<Integer>> primeFactorization = new ArrayList<>();
    private static final int[][] dp = new int[MAX_VALUE +
            MAX_PRIME_FACTORS][MAX_PRIME_FACTORS + 1];
    private static final int MOD = (int) 1e9 + 7;

    public Solution() {
        if (dp[0][0] == 1) {
            return;
        }

        for (int i = 0; i < MAX_VALUE; ++i) {
            primeFactorization.add(new ArrayList<>());
        }

        final int[] smallestPrimeFactor = new int[MAX_VALUE + 1];

        for (int i = 2; i < MAX_VALUE; ++i) {
            if (smallestPrimeFactor[i] == 0) {
                for (int j = i; j < MAX_VALUE; j += i) {
                    smallestPrimeFactor[j] = i;
                }
            }
        }

        for (int i = 2; i < MAX_VALUE; ++i) {
            int num = i;
            while (num > 1) {
                int prime = smallestPrimeFactor[num];
                int cnt = 0;
                while (num % prime == 0) {
                    ++cnt;
                    num /= prime;
                }
                primeFactorization.get(i).add(cnt);
            }
        }

        dp[0][0] = 1;

        for (int i = 1; i < MAX_VALUE + MAX_PRIME_FACTORS; ++i) {
            dp[i][0] = 1;
            for (int j = 1; j <= Math.min(i, MAX_PRIME_FACTORS); ++j) {
                dp[i][j] = (dp[i - 1][j] + dp[i - 1][j - 1]) % MOD;
            }
        }
    }

    public int idealArrays(int n, int maxValue) {
        long answer = 0;

        for (int i = 1; i <= maxValue; ++i) {
            long mul = 1;
            for (int prime : primeFactorization.get(i)) {
                mul = (mul * dp[n + prime - 1][prime]) % MOD;
            }
            answer = (answer + mul) % MOD;
        }

        return (int) answer;
    }
}

public class Main {
   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           int n = scanner.nextInt();
           int maxValue = scanner.nextInt();

           System.out.println(new Solution().idealArrays(n, maxValue));
       }
       
       scanner.close();
   }
}
