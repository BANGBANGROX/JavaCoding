import java.util.Scanner;
import java.util.Arrays;

class Solution {
    private final int MOD = (int) 1e9 + 7;
    private long[][] dp;

    private long lengthAfterTransformationsHandler(char ch, int t) {
        if (t == 0) return 1;

        if (dp[ch - 'a'][t] != -1) return dp[ch - 'a'][t];

        if (ch == 'z') {
            return dp[ch - 'a'][t] = (lengthAfterTransformationsHandler('a', t - 1) +
                    lengthAfterTransformationsHandler('b', t - 1)) % MOD;
        }

        return dp[ch - 'a'][t] = lengthAfterTransformationsHandler((char) (ch + 1), t - 1);
    }

    public int lengthAfterTransformations(String s, int t) {
        long answer = 0;
        int[] count = new int[26];
        dp = new long[26][t + 1];

        for (long[] row : dp) {
            Arrays.fill(row, -1);
        }

        for (char ch : s.toCharArray()) {
            ++count[ch - 'a'];
        }

        for (char ch = 'a'; ch <= 'z'; ++ch) {
            if (count[ch - 'a'] > 0) {
                answer = (answer + (count[ch - 'a'] * lengthAfterTransformationsHandler(ch,
                        t)) % MOD) % MOD;
            }
        }

        return (int) answer;
    }
}

public class Main {
   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           System.out.println(new Solution().lengthAfterTransformations(scanner.next(),
                   scanner.nextInt()));
       }
       
       scanner.close();
   }
}
