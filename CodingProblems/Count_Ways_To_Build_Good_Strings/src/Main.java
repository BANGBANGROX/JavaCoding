import java.util.Scanner;

class Solution {
    public int countGoodStrings(int low, int high, int zero, int one) {
         long[] dp = new long[high + 1];
         long answer = 0;
         final int MOD = 1_000_000_007;

         dp[0] = 1;

         for (int end = 1; end <= high; ++end) {
             if (end >= zero) {
                 dp[end] = (dp[end] + dp[end - zero]) % MOD;
             }
             if (end >= one) {
                 dp[end] = (dp[end] + dp[end - one]) % MOD;
             }
         }

         for (int i = low; i <= high; ++i) {
             answer = (answer + dp[i]) % MOD;
         }

         return (int) answer;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int low = sc.nextInt();
            int high = sc.nextInt();
            int zero = sc.nextInt();
            int one = sc.nextInt();

            Solution solution = new Solution();
            System.out.println(solution.countGoodStrings(low, high, zero, one));
        }

        sc.close();
    }
}
