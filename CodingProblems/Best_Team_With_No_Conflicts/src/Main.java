import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public int bestTeamScore(int[] scores, int[] ages) {
        int n = scores.length;
        int[] dp = new int[n];
        int[][] combinedScoresAges = new int[n][2];

        for (int i = 0; i < n; ++i) {
            combinedScoresAges[i][0] = scores[i];
            combinedScoresAges[i][1] = ages[i];
        }

        Arrays.sort(combinedScoresAges, (a, b) -> a[0] != b[0] ? a[0] -
                b[0] : a[1] - b[1]);

        for (int i = 0; i < n; ++i) {
            dp[i] = combinedScoresAges[i][0];
            int maxValue = 0;
            for (int j = 0; j < i; ++j) {
                if (combinedScoresAges[i][1] >= combinedScoresAges[j][1]) {
                    maxValue = Math.max(maxValue, dp[j]);
                }
            }
            dp[i] += maxValue;
        }

        if (Arrays.stream(dp).max().isPresent())
            return Arrays.stream(dp).max().getAsInt();

        return -1;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            int[] scores = new int[n];
            int[] ages = new int[n];
            for (int i = 0; i < n; ++i) {
                scores[i] = sc.nextInt();
            }
            for (int i = 0; i < n; ++i) {
                ages[i] = sc.nextInt();
            }

            Solution solution = new Solution();
            System.out.print(solution.bestTeamScore(scores, ages));
        }

        sc.close();
    }
}
