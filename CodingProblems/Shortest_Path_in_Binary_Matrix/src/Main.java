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

    public int shortestPathBinaryMatrix(int[][] grid) {
        int length = 1;
        int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
        int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
        int n = grid.length;
        Queue<Pair> q = new LinkedList<>();

        if (n == 1) return 1;

        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) return -1;

        q.add(new Pair(0, 0));
        grid[0][0] = 1;

        while (!q.isEmpty()) {
            ++length;
            int size = q.size();
            for (int i = 0; i < size; ++i) {
                assert q.peek() != null;
                int x = q.peek().first;
                int y = q.peek().second;
                q.poll();
                for (int j = 0; j < 8; ++j) {
                    int newX = x + dx[j];
                    int newY = y + dy[j];
                    if (newX >= 0 && newX < n && newY >= 0 && newY < n && grid[newX][newY] == 0) {
                        if (newX == n - 1 && newY == n - 1) return length;
                        grid[newX][newY] = 1;
                        q.add(new Pair(newX, newY));
                    }
                }
            }
        }

        return -1;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            int[][] grid = new int[n][n];
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    grid[i][j] = sc.nextInt();
                }
            }

            Solution solution = new Solution();
            System.out.println(solution.shortestPathBinaryMatrix(grid));
        }

        sc.close();
    }
}
