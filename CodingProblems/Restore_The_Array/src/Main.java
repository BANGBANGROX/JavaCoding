import java.util.Scanner;

class Solution {
    public int numberOfArrays(String s, int k) {
        int n = s.length();
        long[] dp = new long[n + 1];
        int MOD = (int) 1e9 + 7;

        if (s.charAt(0) - '0' > k) return 0;

        dp[0] = dp[1] = 1;

        for (int i = 2; i <= n; ++i) {
            int num = s.charAt(i - 1) - '0';
            if (num > k) return 0;
            String currentNum = String.valueOf(num);
            if (num > 0) {
                dp[i] = dp[i - 1];
            }
            for (int j = i - 2; j >= 0; --j) {
                currentNum = "" + s.charAt(j) + currentNum;
                if (currentNum.length() > 10) break;
                long longNum = Long.parseLong(currentNum);
                if (longNum > k) break;
                if (s.charAt(j) == '0') continue;
                if (longNum > 0) dp[i] = (dp[i] + dp[j]) % MOD;
            }
        }

        return (int) dp[n];
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();

            Solution solution = new Solution();
            System.out.println(solution.numberOfArrays(s, k));
        }

        sc.close();
    }
}
