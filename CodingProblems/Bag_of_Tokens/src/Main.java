import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);

        int n = tokens.length;
        int l = 0;
        int r = n - 1;
        int ans = 0;
        int points = 0;

        while (l <= r && (power >= tokens[l] || points > 0)) {
            while (l <= r && power >= tokens[l]) {
                ++points;
                power -= tokens[l];
                ++l;
            }
            ans = Math.max(ans, points);
            if (l <= r && points > 0) {
                power += tokens[r];
                --r;
                --points;
            }
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
            int[] tokens = new int[n];
            for (int i = 0; i < n; ++i) {
                tokens[i] = sc.nextInt();
            }
            int power = sc.nextInt();

            Solution solution = new Solution();
            System.out.println(solution.bagOfTokensScore(tokens, power));
        }

        sc.close();
    }
}
