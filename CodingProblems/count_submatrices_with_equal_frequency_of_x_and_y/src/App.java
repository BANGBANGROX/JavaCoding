import java.util.Scanner;

class Solution {
    private char[][] grid;
    private int m;
    private int n;

    private void populatePrefixSum(int[][] prefixSum, char ch) {
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                prefixSum[i][j] = (grid[i][j] == ch ? 1 : 0);
                if (i == 0 && j == 0) {
                    continue;
                } else if (i == 0) {
                    prefixSum[i][j] += prefixSum[i][j - 1];
                } else if (j == 0) {
                    prefixSum[i][j] += prefixSum[i - 1][j];
                } else {
                    prefixSum[i][j] += (prefixSum[i][j - 1] + prefixSum[i - 1][j] - prefixSum[i - 1][j - 1]);
                }
            }
        }
    }

    public int numberOfSubmatrices(char[][] grid) {
        int answer = 0;
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;
        int[][] prefixSumOfX = new int[m][n];
        int[][] prefixSumOfY = new int[m][n];
        
        populatePrefixSum(prefixSumOfX, 'X');
        populatePrefixSum(prefixSumOfY, 'Y');

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (prefixSumOfX[i][j] > 0 && prefixSumOfX[i][j] == prefixSumOfY[i][j]) {
                    ++answer;
                }
            }
        }

        return answer;
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        while (testCases-- > 0) {
            int m = scanner.nextInt();
            int n = scanner.nextInt();
            char[][] grid = new char[m][n];
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    grid[i][j] = scanner.next().charAt(0);
                }
            }

            System.out.println(new Solution().numberOfSubmatrices(grid));
        }

        scanner.close();
    }
}
