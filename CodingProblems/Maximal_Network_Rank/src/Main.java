import java.util.Scanner;

class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
         int[] edgesConnected = new int[n];
         boolean[][] connections = new boolean[n][n];
         int ans = 0;

         for (int[] road : roads) {
             int u = road[0];
             int v = road[1];
             ++edgesConnected[u];
             ++edgesConnected[v];
             connections[u][v] = true;
             connections[v][u] = true;
         }

         for (int i = 0; i < n; ++i) {
             for (int j = i + 1; j < n; ++j) {
                 ans = Math.max(ans, edgesConnected[i] + edgesConnected[j] - (connections[i][j] ? 1 : 0));
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
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] roads = new int[m][2];
            for (int i = 0; i < m; ++i) {
                roads[i][0] = sc.nextInt();
                roads[i][1] = sc.nextInt();
            }

            Solution solution = new Solution();
            System.out.println(solution.maximalNetworkRank(n, roads));
        }

        sc.close();
    }
}
