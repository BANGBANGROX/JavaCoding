import java.util.Scanner;

class Solution {
    private long calculateGCD(long a, long b) {
        if (b == 0) return a;

        return calculateGCD(b, a % b);
    }

    public int minimizeSet(int divisor1, int divisor2, int uniqueCnt1, int uniqueCnt2) {
        int l = 1;
        int r = Integer.MAX_VALUE;
        int ans = -1;
        long gcd = calculateGCD(divisor1, divisor2);
        long lcm = (long) divisor1 * divisor2 / gcd;

        while (l <= r) {
            int mid = (l + ((r - l) >> 1));
            int cnt1 = mid - mid / divisor1;
            int cnt2 = mid - mid / divisor2;
            long combined = mid - mid / lcm;
            if (cnt1 >= uniqueCnt1 && cnt2 >= uniqueCnt2 &&
                    combined >= uniqueCnt1 + uniqueCnt2) {
                {
                    ans = mid;
                    r = mid - 1;
                }
            }
            else l = mid + 1;
        }

        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int divisor1 = sc.nextInt();
            int divisor2 = sc.nextInt();
            int uniqueCnt1 = sc.nextInt();
            int uniqueCnt2 = sc.nextInt();

            Solution solution = new Solution();
            System.out.println(solution.minimizeSet(divisor1, divisor2,
                    uniqueCnt1, uniqueCnt2));
        }

        sc.close();
    }
}
