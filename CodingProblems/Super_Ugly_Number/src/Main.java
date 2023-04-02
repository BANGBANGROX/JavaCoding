import java.util.*;

class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        long[] dp = new long[n];
        HashMap<Integer, Integer> index = new HashMap<>();

        for (int pr : primes) {
            index.put(pr, 0);
        }

        dp[0] = 1;

        for (int i = 1; i < n; ++i) {
            long minValue = Long.MAX_VALUE;
            for (int pr : primes) {
                int idx = index.get(pr);
                minValue = Math.min(minValue, dp[idx] * pr);
            }
            for (int pr : primes) {
                int idx = index.get(pr);
                if (minValue == dp[idx] * pr) {
                    index.put(pr, idx + 1);
                    //break;
                }
            }
            dp[i] = minValue;
        }

        return (int) dp[n - 1];
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            int len = sc.nextInt();
            int[] primes = new int[len];
            for (int i = 0; i < len; ++i) {
                primes[i] = sc.nextInt();
            }

            Solution solution = new Solution();
            System.out.println(solution.nthSuperUglyNumber(n, primes));
        }

        sc.close();
    }
}
