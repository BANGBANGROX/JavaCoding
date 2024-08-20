import java.util.Arrays;
import java.util.Scanner;

class Solution {
    private static class Pair {
        int first;
        int second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    private Pair[][] grid;
    private long[][] dp;
    private final long INF = (long) 1e16;
    private int firstRookPosition;

    private long maximumValueSumHandler(int row,
                                        int secondRookPosition) {
        if (row >= grid.length) {
            return -1 * INF;
        }

        if (dp[row][secondRookPosition + 1] != -1) {
            return dp[row][secondRookPosition + 1];
        }

        long result = maximumValueSumHandler(row + 1, secondRookPosition);

        for (int col = 0; col < 3; ++col) {
            if (grid[row][col].second != firstRookPosition &&
                    grid[row][col].second != secondRookPosition) {
                if (secondRookPosition == -1) {
                    result = Math.max(result, grid[row][col].first + maximumValueSumHandler(row + 1, grid[row][col].second));
                } else {
                    result = Math.max(result, grid[row][col].first);
                }
            }
        }

        return dp[row][secondRookPosition + 1] = result;
    }

    public long maximumValueSum(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        grid = new Pair[m][n];
        dp = new long[m][n + 1];
        long answer = -1 * INF;

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                grid[i][j] = new Pair(board[i][j], j);
            }
            Arrays.sort(grid[i], (a, b) -> a.first != b.first ? b.first - a.first :
                    b.second - a.second);
        }

        Arrays.sort(grid, (a, b) -> {
            for (int i = 0; i < a.length; ++i) {
                if (a[i].first != b[i].first) {
                    return b[i].first - a[i].first;
                }
            }

            return 0;
        });

        for (int col = 0; col < 3; ++col) {
            firstRookPosition = grid[0][col].second;
            for (int i = 0; i < m; ++i) {
                Arrays.fill(dp[i], -1);
            }
            answer = Math.max(answer, grid[0][col].first +
                    maximumValueSumHandler(1, -1));
        }

        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        while (testCases-- > 0) {
            int m = scanner.nextInt();
            int n = scanner.nextInt();
            int[][] board = new int[m][n];
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    board[i][j] = scanner.nextInt();
                }
            }

            System.out.println(new Solution().maximumValueSum(board));
        }
    }
}