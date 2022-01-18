import java.util.Scanner;

class Solution {
    private long[] dp;
    private int n;

    private long mostPointsUtil(int index, int[][] questions) {
        if (index >= n) return 0;

        if (dp[index] != -1) return dp[index];

        long ans;

        // Solve the current question.
        ans = mostPointsUtil(index + questions[index][1] + 1, questions) + questions[index][0];

        // Leave the current question.
        ans = Math.max(ans, mostPointsUtil(index + 1, questions));

        return dp[index] = ans;
    }

    public long mostPoints(int[][] questions) {
         n = questions.length;
         dp = new long[n];

         for (int i = 0; i < n; ++i) {
             dp[i] = -1;
         }

         return mostPointsUtil(0, questions);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            int[][] questions = new int[n][2];
            for (int i = 0; i < n; ++i) {
                questions[i][0] = sc.nextInt();
                questions[i][1] = sc.nextInt();
            }

            Solution solution = new Solution();
            System.out.println(solution.mostPoints(questions));
        }

        sc.close();
    }
}
