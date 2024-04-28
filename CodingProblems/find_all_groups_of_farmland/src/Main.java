import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class Solution {
    private int[][] land;
    private int m;
    private int n;
    private int maxX;
    private int maxY;

    private void dfs(int x, int y) {
        if (x < 0 || y < 0 || x >= m || y >= n || land[x][y] == 0) {
            return;
        }

        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        land[x][y] = 0;
        maxX = Math.max(maxX, x);
        maxY = Math.max(maxY, y);

        for (int[] direction : directions) {
            int newX = x + direction[0];
            int newY = y + direction[1];
            dfs(newX, newY);
        }
    }

    public int[][] findFarmland(int[][] land) {
        ArrayList<ArrayList<Integer>> answer = new ArrayList<>();
        this.land = land;
        m = land.length;
        n = land[0].length;

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (land[i][j] == 1) {
                    maxX = i;
                    maxY = j;
                    dfs(i, j);
                    answer.add(new ArrayList<>(Arrays.asList(i, j, maxX, maxY)));
                }
            }
        }

        int[][] finalAnswer = new int[answer.size()][4];

        for (int i = 0; i < answer.size(); ++i) {
            finalAnswer[i] = new int[]{answer.get(i).get(0), answer.get(i).get(1), answer.get(i).get(2), answer.get(i).get(3)};
        }

        return finalAnswer;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            int[][] land = new int[m][n];
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    land[i][j] = sc.nextInt();
                }
            }

            Solution solution = new Solution();
            int[][] answer = solution.findFarmland(land);
            for (int[] x : answer) {
                for (int y : x) {
                    System.out.print(y + " ");
                }
                System.out.println();
            }
        }

        sc.close();
    }
}
