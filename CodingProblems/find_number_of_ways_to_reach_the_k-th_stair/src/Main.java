import java.util.Scanner;

class Solution {
    private int calculateNCR(int n, int r) {
        if (r > n) return 0;

        long result = 1;

        for (int i = 1; i <= r; ++i) {
            result *= (n - i + 1);
            result /= i;
        }

        return (int) result;
    }

    public int waysToReachStair(int k) {
        if (k == 0 || k == 4) return 2;

        if (k == 1 || k == 2) return 4;

        int powerOf2 = (int) Math.ceil(Math.log10(k) / Math.log10(2));
        int val = (1 << powerOf2);
        int diff = val - k;

        return calculateNCR(powerOf2 + 1, diff);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int k = sc.nextInt();

            System.out.println(new Solution().waysToReachStair(k));
        }

        sc.close();
    }
}
