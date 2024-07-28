import java.util.Scanner;

class Solution {
    private int[] parent;
    
    private int find(int node) {
        if (parent[node] == node) {
            return node;
        }

        return parent[node] = find(parent[node]);
    }

    public boolean canReachCorner(int X, int Y, int[][] circles) {
        int n = circles.length;
        parent = new int[n + 2];

        for (int i = 0; i <= n + 1; ++i) {
            parent[i] = i;
        }

        for (int i = 0; i < n; ++i) {
            int x = circles[i][0];
            int y = circles[i][1];
            int r = circles[i][2];
            if (x - r >= X || y -r >= Y) continue;
            if (x - r <= 0 || y + r >= Y) {
                parent[find(n)] = find(i);
            }
            if (x + r >= X || y - r <= 0) {
                parent[find(n + 1)] = find(i);
            }
            for (int j = i + 1; j < n; ++j) {
                int x2 = circles[j][0];
                int y2 = circles[j][1];
                int r2 = circles[j][2];
                if ((x - x2) * (x - x2) + (y - y2) * (y - y2) - (r + r2) * (r + r2) <= 0) {
                    parent[find(i)] = find(j);
                }
            }
        }

        return find(n) != find(n + 1);
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        while (testCases-- > 0) {
            int X = scanner.nextInt();
            int Y = scanner.nextInt();
            int n = scanner.nextInt();
            int[][] circles = new int[n][3];
            for (int i = 0; i < n; ++i) {
                circles[i][0] = scanner.nextInt();
                circles[i][1] = scanner.nextInt();
                circles[i][2] = scanner.nextInt();
            }

            System.out.println(new Solution().canReachCorner(X, Y, circles));
        }

        scanner.close();
    }
}
