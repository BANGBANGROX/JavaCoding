import java.util.*;

class Solution {
    private static class Pair {
        int first;
        int second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> ans = new ArrayList<>();
        int m = heights.length;
        int n = heights[0].length;
        int[][] state = new int[m][n];
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        Queue<Pair> q = new LinkedList<>();

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i == 0 || j == 0) {  // First row or first col
                    q.add(new Pair(i, j));
                    state[i][j] = 1;
                }
                if (i == m - 1 || j == n - 1) { // Last row or last col
                    q.add(new Pair(i, j));
                    state[i][j] += 2;
                }
            }
        }

        while (!q.isEmpty()) {
            int x = q.peek().first;
            int y = q.peek().second;
            q.poll();
            for (int i = 0; i < 4; ++i) {
                int newX = x + dx[i];
                int newY = y + dy[i];
                if (newX >= 0 && newX < m && newY >= 0 && newY < n && state[newX][newY] != state[x][y]
                        && state[newX][newY] != 3 && heights[newX][newY] >= heights[x][y]) {
                    q.add(new Pair(newX, newY));
                    state[newX][newY] += state[x][y];
                    state[newX][newY] = Math.min(3, state[newX][newY]);
                }
            }
        }

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (state[i][j] == 3) ans.add(Arrays.asList(i, j));
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
            int[][] heights = new int[m][n];
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    heights[i][j] = sc.nextInt();
                }
            }

            Solution solution = new Solution();
            System.out.println(solution.pacificAtlantic(heights));
        }

        sc.close();
    }
}
