import java.util.Scanner;

class Solution {
    private long[][] dp;
    private String num;
    private String s;
    private int limit;

    private long numberOfPowerfulIntHandler(int rem, int tight) {
        if (num.length() < s.length()) return 0;

        if (dp[rem][tight] != -1) return dp[rem][tight];

        int upperBound = tight > 0 ? num.charAt(num.length() - rem) - '0' : limit;
        long answer = 0;

        if (rem == 1) {
            return s.charAt(s.length() - 1) - '0' > upperBound ? 0 : 1;
        }

        // Deciding on the suffix
        if (rem <= s.length()) {
            if (tight > 0) {
                int lastDig = s.charAt(s.length() - rem) - '0';
                if (lastDig < upperBound) return 1;
                else if (lastDig == upperBound) {
                    return numberOfPowerfulIntHandler(rem - 1, 1);
                } else return 0;
            }
            return 1;
        }

        // Deciding on the digits before suffix
        for (int dig = 0; dig <= upperBound && dig <= limit; ++dig) {
            answer = (answer + numberOfPowerfulIntHandler(rem - 1, tight & (dig == upperBound ? 1 : 0)));
        }

        return dp[rem][tight] = answer;
    }

    public long numberOfPowerfulInt(long start, long finish, int limit, String s) {
        dp = new long[20][2];
        this.s = s;
        this.limit = limit;

        num = String.valueOf(finish);
        for (int i = 0; i < 20; ++i) {
            dp[i][0] = dp[i][1] = -1;
        }
        long finishResult = numberOfPowerfulIntHandler(num.length(), 1);

        num = String.valueOf(start - 1);
        for (int i = 0; i < 20; ++i) {
            dp[i][0] = dp[i][1] = -1;
        }
        long startResult = numberOfPowerfulIntHandler(num.length(), 1);

        return finishResult - startResult;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            long start = sc.nextLong();
            long finish = sc.nextLong();
            int limit = sc.nextInt();
            String s = sc.next();

            Solution solution = new Solution();
            System.out.println(solution.numberOfPowerfulInt(start, finish, limit, s));
        }

        sc.close();
    }
}
