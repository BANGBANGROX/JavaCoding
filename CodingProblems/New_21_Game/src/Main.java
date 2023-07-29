import java.util.Scanner;

class Solution {
    public double new21Game(int n, int k, int maxPts) {
         double[] dp = new double[n + 1];
         double score = k > 0 ? 1 : 0;
         double answer = 0;

         dp[0] = 1;

         for (int i = 1; i <= n; ++i) {
             dp[i] = score / maxPts;
             if (i < k) score += dp[i];
             if ((i - maxPts) >= 0 && (i - maxPts) < k) score -= dp[i - maxPts];

         }

         for (int i = k; i <= n; ++i) {
             answer += dp[i];
         }

         return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int maxPts = sc.nextInt();

            Solution solution = new Solution();
            System.out.println(solution.new21Game(n, k, maxPts));
        }

        sc.close();
    }
}
