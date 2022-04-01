import java.util.Scanner;

class Solution {
    private void dfs(int node, int[][] isConnected, boolean[] visited) {
        visited[node] = true;

        for (int i = 0; i < isConnected.length; ++i) {
            if (isConnected[node][i] == 1 && !visited[i]) {
                dfs(i, isConnected, visited);
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int ans = 0;
        int n = isConnected.length;
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; ++i) {
            if (!visited[i]) {
                ++ans;
                dfs(i, isConnected, visited);
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
        }

        sc.close();
    }
}
