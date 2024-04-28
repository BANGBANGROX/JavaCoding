import java.util.Scanner;

class Solution {
    private int[] coins;
    private int k;
    private int n;

    private long calculateGCD(long a, long b) {
        if (b == 0) return a;

        return calculateGCD(b, a % b);
    }

    private boolean checkValue(long value) {
        long totalDenominations = 0;

        for (int bitSet = 1; bitSet < (1 << n); ++bitSet) {
            int totalSetBits = 0;
            long gcd = 0;
            long lcm = 0;
            for (int i = 0; i < n; ++i) {
                if ((bitSet & (1 << i)) > 0) {
                    ++totalSetBits;
                    if (gcd == 0) {
                        gcd = coins[i];
                        lcm = coins[i];
                    }
                    else {
                        gcd = calculateGCD(lcm, coins[i]);
                        lcm = lcm * coins[i] / gcd;
                    }
                }
            }
            if (value == 3) {
                System.out.println(bitSet + " " + gcd + " " + lcm);
            }
            totalDenominations += (((totalSetBits & 1) > 0) ? (value / lcm) : (-1) * (value / lcm));
        }

        if (value == 3) {
            System.out.println(totalDenominations);
        }

        return totalDenominations >= k;
    }

    public long findKthSmallest(int[] coins, int k) {
        this.coins = coins;
        this.k = k;
        n = coins.length;
        long left = 1;
        long right = (long) 1e15;
        long answer = -1;

        while (left <= right) {
            long mid = (left + ((right - left) >> 1));
            if (checkValue(mid)) {
                answer = mid;
                right = mid - 1;
            }
            else {
                left = mid + 1;
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
            int[] coins = new int[n];
            for (int i = 0; i < n; ++i) {
                coins[i] = sc.nextInt();
            }
            int k = sc.nextInt();

            Solution solution = new Solution();
            System.out.println(solution.findKthSmallest(coins, k));
        }

        sc.close();
    }
}
