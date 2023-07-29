import java.util.Scanner;

class Solution {
    public double knightProbability(int n, int k, int row, int column) {
        int[][] directions = {{-2, 1}, {1, 2}, {2, 1}, {2, -1},
                {1, -2}, {-1, -2}, {-2, -1}, {-1, 2}};
        double[][][] dp = new double[k + 1][n][n];
        double answer = 0;

        dp[0][row][column] = 1;

        for (int move = 1; move <= k; ++move) {
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    for (int[] direction : directions) {
                        int prevI = i - direction[0];
                        int prevJ = j - direction[1];
                        if (prevI >= 0 && prevI < n && prevJ >= 0 && prevJ < n) {
                            dp[move][i][j] += (dp[move - 1][prevI][prevJ] / 8.0);
                        }
                    }
                }
            }
        }

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                answer += dp[k][i][j];
            }
        }

        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int row = sc.nextInt();
            int column = sc.nextInt();

            Solution solution = new Solution();
            System.out.println(solution.knightProbability(n, k, row, column));
        }

        sc.close();
    }
}
