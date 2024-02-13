import java.util.Scanner;

class Solution {
    private long k;
    private int x;

    // This method counts numbers with ith bit set <= num
    private long countNumsWithIthBitSet(long num, int i) {
        long modWith2 = num % (1L << (i + 1));

        return ((num - modWith2) >> 1) + Math.max(modWith2 - (1L << i), 0);
    }

    private boolean check(long num) {
        long totalSum = 0;

        for (int bit = x - 1; bit < 63; bit += x) {
            totalSum += countNumsWithIthBitSet(num, bit);
            if (totalSum > k) return false;
        }

        return true;
    }

    public long findMaximumNumber(long k, int x) {
        this.k = k;
        this.x = x;
        long l = 1;
        long r = (long) 1e15;
        long answer = -1;

        while (l <= r) {
            long mid = (l + r) / 2;
            if (check(mid)) {
                l = mid + 1;
                answer = mid;
            } else {
                r = mid - 1;
            }
        }

        return answer - 1;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            long k = sc.nextLong();
            int x = sc.nextInt();

            Solution solution = new Solution();
            System.out.println(solution.findMaximumNumber(k, x));
        }

        sc.close();
    }
}
