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

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        Queue<Pair> q = new LinkedList<>();
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        int m = image.length;
        int n = image[0].length;
        boolean[][] visited = new boolean[m][n];

        q.add(new Pair(sr, sc));
        visited[sr][sc] = true;

        while (!q.isEmpty()) {
            int x = q.peek().first;
            int y = q.peek().second;
            q.poll();
            for (int i = 0; i < 4; ++i) {
                int newX = x + dx[i];
                int newY = y + dy[i];
                if (newX >= 0 && newX < m && newY >= 0 && newY < n && image[newX][newY] == image[x][y] &&
                        !visited[newX][newY]) {
                    q.add(new Pair(newX, newY));
                    visited[newX][newY] = true;
                }
            }
            image[x][y] = newColor;
        }

        return image;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            int[][] image = new int[m][n];
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    image[i][j] = sc.nextInt();
                }
            }
            int newColor = sc.nextInt();
            int sr = sc.nextInt();
            int scc = sc.nextInt();

            Solution solution = new Solution();
            int[][] newImage = solution.floodFill(image, sr, scc, newColor);
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    System.out.print(newImage[i][j] + " ");
                }
                System.out.println();
            }
        }

        sc.close();
    }
}
