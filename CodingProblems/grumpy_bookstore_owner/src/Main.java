import java.util.Scanner;

class Solution {
    private int[][] dp;
    private int[] customers;
    private int[] customersPrefixSum;
    private int[] grumpy;
    private int minutes;
    private int n;

    private int getCustomersSatisfied(int left, int right) {
        right = Math.min(n - 1, right);

        return customersPrefixSum[right] - (left > 0 ? customersPrefixSum[left - 1] : 0);
    }

    private int maxSatisfiedHandler(int idx, boolean minutesUsed) {
        if (idx >= n) {
            return 0;
        }

        int secondState = minutesUsed ? 1 : 0;

        if (dp[idx][secondState] != -1) return dp[idx][secondState];

        int result;

        if (grumpy[idx] == 0) {
            result = customers[idx] + maxSatisfiedHandler(idx + 1, minutesUsed);
        } else {
            result = maxSatisfiedHandler(idx + 1, minutesUsed);
            if (!minutesUsed) {
                result = Math.max(result, getCustomersSatisfied(idx, idx + minutes - 1) + maxSatisfiedHandler(idx + minutes, true));
            }
        }

        return dp[idx][secondState] = result;
    }


    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        this.customers = customers;
        this.grumpy = grumpy;
        this.minutes = minutes;
        n = customers.length;
        customersPrefixSum = new int[n];
        dp = new int[n][2];

        customersPrefixSum[0] = customers[0];
        dp[0][0] = dp[0][1] = -1;

        for (int i = 1; i < n; ++i) {
            customersPrefixSum[i] = customersPrefixSum[i - 1] + customers[i];
            dp[i][0] = dp[i][1] = -1;
        }

        return maxSatisfiedHandler(0, false);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            int[] customers = new int[n];
            for (int i = 0; i < n; ++i) {
                customers[i] = sc.nextInt();
            }
            int[] grumpy = new int[n];
            for (int i = 0; i < n; ++i) {
                grumpy[i] = sc.nextInt();
            }
            int minutes = sc.nextInt();

            System.out.println(new Solution().maxSatisfied(customers, grumpy, minutes));
        }

        sc.close();
    }
}
