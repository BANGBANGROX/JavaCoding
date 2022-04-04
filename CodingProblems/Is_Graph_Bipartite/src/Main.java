import java.util.Scanner;

class Solution {
    private boolean[] visited;
    private boolean[] color;

    private boolean isNotBipartite(int node, int[][] graph) {
        visited[node] = true;

        for (int child : graph[node]) {
            if (!visited[child]) {
                color[child] = !color[node];
                if (isNotBipartite(child, graph)) return true;
            }
            else if (color[node] == color[child]) return true;
        }

        return false;
    }

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        visited = new boolean[n];
        color = new boolean[n];

        for (int i = 0; i < n; ++i) {
            if (!visited[i] && isNotBipartite(i, graph)) return false;
        }

        return true;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            int[][] graph = new int[n][];
            for (int i = 0; i < n; ++i) {
                int m = sc.nextInt();
                graph[i] = new int[m];
                for (int j = 0; j < m; ++j) {
                    graph[i][j] = sc.nextInt();
                }
            }

            Solution solution = new Solution();
            System.out.println(solution.isBipartite(graph));
        }

        sc.close();
    }
}
