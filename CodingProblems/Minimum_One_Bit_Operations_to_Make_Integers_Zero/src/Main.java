import java.util.Scanner;

class Solution {
    public int minimumOneBitOperations(int n) {
         int[] dp = new int[31];
         int answer = 0;
         boolean add = true;

         dp[0] = 1;

         for (int i = 1; i <= 30; ++i) {
             dp[i] = dp[i - 1] * 2 + 1;
         }

         for (int i = 31; i >= 0; --i) {
             if ((n & (1 << i)) > 0) {
                 if (add) answer += dp[i];
                 else answer -= dp[i];
                 add ^= true;
             }
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

            Solution solution = new Solution();
            System.out.println(solution.minimumOneBitOperations(n));
        }

        sc.close();
    }
}
