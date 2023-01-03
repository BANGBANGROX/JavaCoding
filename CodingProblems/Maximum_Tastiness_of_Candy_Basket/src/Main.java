import java.util.Arrays;
import java.util.Scanner;

class Solution {
    private boolean check(int[] price, int diff, int k) {
        int next = price[0] + diff;
        int n = price.length;
        --k;

        for (int i = 1; i < n; ++i) {
            if (price[i] >= next) {
                --k;
                if (k == 0) return true;
                next = price[i] + diff;
            }
        }

        return k == 0;
    }

    public int maximumTastiness(int[] price, int k) {
        Arrays.sort(price);

        int l = 1;
        int r = (int) 1e9;

        while (l <= r) {
            int mid = (l + ((r - l) >> 1));
            if (check(price, mid, k)) {
                l = mid + 1;
            }
            else r = mid - 1;
        }

        return l - 1;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            int[] price = new int[n];
            for (int i = 0; i < n; ++i) {
                price[i] = sc.nextInt();
            }
            int k = sc.nextInt();

            Solution solution = new Solution();
            System.out.println(solution.maximumTastiness(price, k));
        }

        sc.close();
    }
}
