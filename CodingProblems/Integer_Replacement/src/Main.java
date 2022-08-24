import java.util.Scanner;

class Solution {
    public int integerReplacement(int n) {
        int ans = 0;

        if (n == Integer.MAX_VALUE) return 32;

        while (n > 1) {
            if ((n & 1) == 0) n /= 2;
            else {
                int p1 = n + 1;
                int p2 = n - 1;
                int cnt1 = 0;
                int cnt2 = 0;
                while (p1 % 2 == 0) {
                    p1 /= 2;
                    ++cnt1;
                }
                while (p2 % 2 == 0) {
                    p2 /= 2;
                    ++cnt2;
                }
                System.out.println(p1 + " " + p2);
                if (p1 == 1 && p2 == 1) return ans + Math.min(cnt1, cnt2) + 1;
                if (p1 == 1) return ans + cnt1 + 1;
                if (p2 == 1) return ans + cnt2 + 1;
                if (cnt1 > cnt2) ++n;
                else --n;
            }
            ++ans;
        }

        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();

            Solution solution = new Solution();
            System.out.println(solution.integerReplacement(n));
        }

        sc.close();
    }
}
