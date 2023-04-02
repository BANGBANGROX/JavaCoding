import java.util.Arrays;
import java.util.Scanner;

class Solution {
    private boolean check(int[] weights, int cap, int days) {
        int current = 0;

        for (int wt : weights) {
            if (wt > cap) return false;
            if (current + wt <= cap) {
                current += wt;
            }
            else {
                current = wt;
                --days;
                if (days <= 0) return false;
            }
        }

        return true;
    }

    public int shipWithinDays(int[] weights, int days) {
        int l = 0;
        int r = Arrays.stream(weights).sum();

        while (l <= r) {
            int mid = (l + ((r - l) >> 1));
            if (check(weights, mid, days)) {
                r = mid - 1;
            }
            else l = mid + 1;
        }

        return l;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            int[] weights = new int[n];
            for (int i = 0; i < n; ++i) {
                weights[i] = sc.nextInt();
            }
            int days = sc.nextInt();

            Solution solution = new Solution();
            System.out.println(solution.shipWithinDays(weights, days));
        }

        sc.close();
    }
}
