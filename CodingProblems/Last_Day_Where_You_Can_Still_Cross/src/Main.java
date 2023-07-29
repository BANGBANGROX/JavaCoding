import java.util.Scanner;

class Solution {
    private int rows;
    private int cols;
    private int[][] grid;
    private int[][] cells;

    private boolean dfs(int x, int y) {
        if (x < 0 || x >= rows || y < 0 || y >= cols || grid[x][y] != 0) return false;

        if (x == rows - 1) return true;

        grid[x][y] = -1;

        int[][] directions = {{-1, 0}, {0, 1}, {0, -1}, {1, 0}};

        for (int[] direction : directions) {
            int newX = x + direction[0];
            int newY = y + direction[1];
            if (dfs(newX, newY)) return true;
        }

        return false;
    }

    private boolean check(int days) {
        grid = new int[rows][cols];

        for (int i = 0; i < days; ++i) {
            int r = cells[i][0] - 1;
            int c = cells[i][1] - 1;
            grid[r][c] = 1;
        }

        for (int i = 0; i < cols; ++i) {
            if (grid[0][i] == 0 && dfs(0, i)) return true;
        }

        return false;
    }

    public int latestDayToCross(int rows, int cols, int[][] cells) {
        this.rows = rows;
        this.cols = cols;
        this.cells = cells;

        int start = 1;
        int end = rows * cols;

        while (start < end) {
            int mid = (end - ((end - start) >> 1));
            if (check(mid)) {
                start = mid;
            }
            else {
                end = mid - 1;
            }
        }

        return start;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int rows = sc.nextInt();
            int cols = sc.nextInt();
            int n = sc.nextInt();
            int[][] cells = new int[n][2];
            for (int i = 0; i < n; ++i) {
                cells[i][0] = sc.nextInt();
                cells[i][1] = sc.nextInt();
            }

            Solution solution = new Solution();
            System.out.println(solution.latestDayToCross(rows, cols, cells));
        }

        sc.close();
    }
}
