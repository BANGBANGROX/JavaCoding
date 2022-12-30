import java.util.ArrayList;
import java.util.Scanner;

class Solution {
    private final ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    private boolean[] visited;

    private boolean dfs(int node, int destination) {
        if (node == destination) return true;

        visited[node] = true;

        for (int child : graph.get(node)) {
            if (!visited[child]) {
                if (dfs(child, destination)) return true;
            }
        }

        return false;
    }

    public boolean validPath(int n, int[][] edges, int source, int destination) {
          visited = new boolean[n];

          for (int i = 0; i < n; ++i) {
              graph.add(new ArrayList<>());
          }

          for (int[] edge : edges) {
              int u = edge[0];
              int v = edge[1];
              graph.get(u).add(v);
              graph.get(v).add(u);
          }

          return dfs(source, destination);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] edges = new int[m][2];
            
            for (int i = 0; i < m; ++i) {
                edges[i][0] = sc.nextInt();
                edges[i][1] = sc.nextInt();
            }
            int source = sc.nextInt();
            int destination = sc.nextInt();
            
            Solution solution = new Solution();
            System.out.println(solution.validPath(n, edges, source, destination));
        }

        sc.close();
    }
}
