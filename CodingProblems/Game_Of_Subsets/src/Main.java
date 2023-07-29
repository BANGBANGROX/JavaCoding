//{ Driver Code Starts
// Initial Template for Java

import java.util.Scanner;

// Position this line where user code will be pasted.

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            Solution ob = new Solution();
            int ans = ob.goodSubsets(a, n);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    private final int MOD = 1_000_000_007;
    private final int PRIME_NUMBER_COUNT = 10;
    private final int MAX_VALUE = 30;

    private int[] computeInitialPrimeMask() {
        final int[] PRIME_NUMBERS = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};
        int[] initialPrimeMask = new int[MAX_VALUE + 1];

        for (int num = 2; num <= MAX_VALUE; ++num) {
              if (num % 4 == 0 || num % 9 == 0 || num == 25) continue;
              int currentMask = 0;
              for (int i = 0; i < PRIME_NUMBER_COUNT; ++i) {
                  int primeNumber = PRIME_NUMBERS[i];
                  if (num % primeNumber == 0) {
                      currentMask |= (1 << i);
                  }
              }
              initialPrimeMask[num] = currentMask;
        }

        return initialPrimeMask;
    }

    private int calculatePowerOfTwo(int power) {
        long answer = 1;
        long initialValue = 2;

        while (power > 0) {
            if ((power & 1) > 0) {
                answer = (answer * initialValue) % MOD;
                --power;
            }
            initialValue = (initialValue * initialValue) % MOD;
            power >>= 1;
        }

        return (int) answer;
    }

    public int goodSubsets(int[] nums, int n) {
        // Code here
        long[] dp = new long[(1 << PRIME_NUMBER_COUNT)];
        int[] initialPrimeMask = computeInitialPrimeMask();
        int[] primeCount = new int[MAX_VALUE + 1];
        int onesCount = 0;
        long answer = 0;

        for (int i = 0; i < n; ++i) {
            int num = nums[i];
            if (num == 1) {
                ++onesCount;
            }
            else if (initialPrimeMask[num] > 0) {
                ++primeCount[num];
            }
        }

        dp[0] = 1;

        for (int num = 1; num <= MAX_VALUE; ++num) {
            if (primeCount[num] == 0) continue;
            int primeMask = initialPrimeMask[num];
            for (int mask = 0; mask < (1 << PRIME_NUMBER_COUNT); ++mask) {
                if ((primeMask & mask) > 0) continue;
                dp[mask | primeMask] = (dp[mask | primeMask] +
                        (dp[mask] * primeCount[num]) % MOD) % MOD;
            }
        }

        for (long val : dp) {
            answer = (answer + val) % MOD;
        }

        answer = (answer - 1 + MOD) % MOD;

        if (onesCount > 0) {
            answer = (answer * calculatePowerOfTwo(onesCount)) % MOD;
        }

        return (int) answer;
    }
}