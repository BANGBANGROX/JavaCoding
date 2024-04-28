import java.util.Arrays;
import java.util.Scanner;

class Solution {
    private String s;
    private String t;
    private int[][] dp;

    private int numDistinctHandler(int idx1, int idx2) {
        if (idx2 >= t.length()) return 1;

        if (idx1 >= s.length()) return 0;

        if (dp[idx1][idx2] != -1) return dp[idx1][idx2];

        return dp[idx1][idx2] = numDistinctHandler(idx1 + 1, idx2) + (s.charAt(idx1) == t.charAt(idx2) ? numDistinctHandler(idx1 + 1, idx2 + 1) : 0);
    }

    public int numDistinct(String s, String t) {
        this.s = s;
        this.t = t;
        dp = new int[s.length()][t.length()];

        for (int[] innerDp : dp) {
            Arrays.fill(innerDp, -1);
        }

        return numDistinctHandler(0, 0);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            String s = sc.next();
            String t = sc.next();

            System.out.println(new Solution().numDistinct(s, t));
        }

        sc.close();
    }
}
