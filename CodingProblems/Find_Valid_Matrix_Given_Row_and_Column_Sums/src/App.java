class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int m = rowSum.length;
        int n = colSum.length;
        int[][] answer = new int[m][n];

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                answer[i][j] = Math.min(rowSum[i], colSum[j]);
                rowSum[i] -= answer[i][j];
                colSum[j] -= answer[i][j];
            }
        }

        return answer;
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
