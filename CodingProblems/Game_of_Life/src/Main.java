import java.util.Scanner;

class Solution {
    public void gameOfLife(int[][] board) {
         int m = board.length;
         int n = board[0].length;
         int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
         int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
         int[][] ans = new int[m][n];

         for (int i = 0; i < m; ++i) {
             for (int j = 0; j < n; ++j) {
                int liveNeighbours = 0;
                ans[i][j] = board[i][j];
                for (int k = 0; k < 8; ++k) {
                    int x = i + dx[k];
                    int y = j + dy[k];
                    if (x >= 0 && x < m && y >= 0 && y < n && board[x][y] == 1) {
                        ++liveNeighbours;
                    }
                }
                if (board[i][j] == 1) {
                    if (liveNeighbours < 2 || liveNeighbours > 3) ans[i][j] = 0;
                }
                else {
                    if (liveNeighbours == 3) ans[i][j] = 1;
                }
             }
         }

         for (int i = 0; i < m; ++i) {
             System.arraycopy(ans[i], 0, board[i], 0, n);
         }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            int[][] board = new int[m][n];
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    board[i][j] = sc.nextInt();
                }
            }

            Solution solution = new Solution();
            solution.gameOfLife(board);
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }
        }

        sc.close();
    }
}
