import java.util.LinkedList;
import java.util.Queue;
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

    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] ans = new int[m][n];
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        Queue<Pair> q = new LinkedList<>();

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (mat[i][j] == 0) q.add(new Pair(i, j));
                else ans[i][j] = Integer.MAX_VALUE;
            }
        }

        while (!q.isEmpty()) {
            int x = q.peek().first;
            int y = q.peek().second;
            q.poll();
            for (int i = 0; i < 4; ++i) {
                int newX = x + dx[i];
                int newY = y + dy[i];
                if (newX >= 0 && newX < m && newY >= 0 && newY < n && ans[newX][newY] > ans[x][y] + 1) {
                    q.add(new Pair(newX, newY));
                    ans[newX][newY] = 1 + ans[x][y];
                }
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
            int m = sc.nextInt();
            int n = sc.nextInt();
            int[][] mat = new int[m][n];
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    mat[i][j] = sc.nextInt();
                }
            }

            Solution solution = new Solution();
            int[][] ans = solution.updateMatrix(mat);
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }

        sc.close();
    }
}
