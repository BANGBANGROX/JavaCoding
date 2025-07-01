import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution {
    public List<Integer> findCoins(final int[] numWays) {
        final List<Integer> answer = new ArrayList<>();
        final int n = numWays.length;

        for (int i = 0; i < n; ++i) {
            final int minWays = countWays(i + 1, answer);
            if (minWays > numWays[i] || minWays < numWays[i] - 1) {
                return new ArrayList<>();
            } else if (minWays == numWays[i] - 1) {
                answer.add(i + 1);
            }
        }

        return answer;
    }

    private int countWays(final int sum, final List<Integer> coins) {
        final int[] dp = new int[sum + 1];

        dp[0] = 1;

        for (final int coin : coins) {
            for (int j = coin; j <= sum; ++j) {
                dp[j] += dp[j - coin];
            }
        }

        return dp[sum];
    }
}

public class Main {
   public static void main(String[] args) {
       final Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           final int n = scanner.nextInt();
           final int[] numWays = new int[n];
           for (int i = 0; i < n; ++i) {
               numWays[i] = scanner.nextInt();
           }

           System.out.println(new Solution().findCoins(numWays));
       }
       
       scanner.close();
   }
}
