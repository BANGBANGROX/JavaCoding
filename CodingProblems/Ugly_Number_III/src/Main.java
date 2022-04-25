import java.util.Scanner;

class Solution {
    private long gcd(long a, long b) {
        if (b == 0) return a;

        return gcd(b, a % b);
    }

    private long calculateLCM(long ...nums) {
        int n = nums.length;
        long lcm = nums[0];

        for (int i = 1; i < n; ++i) {
            lcm = (lcm * nums[i]) / gcd(lcm, nums[i]);
        }

        return lcm;
    }

    public int nthUglyNumber(int n, int a, int b, int c) {
         long l = 1;
         long r = (int) 2e9 + 5;

         while (l < r) {
             long mid = (r + ((r - l) >> 1));
             long count = mid / a + mid / b + mid / c - mid / calculateLCM(a, b) - mid / calculateLCM(b, c)
                     - mid / calculateLCM(a, c) + mid / calculateLCM(a, b, c);
             if (count < n) l = mid + 1;
             else r = mid - 1;
         }

         return (int) l;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            Solution solution = new Solution();
            System.out.println(solution.nthUglyNumber(n, a, b, c));
        }

        sc.close();
    }
}
