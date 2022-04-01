import java.util.*;

class Solution {
    private void dfs(int node, boolean[] visited, List<List<Integer>> graph) {
       visited[node] = true;

       for (int child : graph.get(node)) {
           if (!visited[child]) dfs(child, visited, graph);
       }
    }

    public int makeConnected(int n, int[][] connections) {
         boolean[] visited = new boolean[n];
         List<List<Integer>> graph = new ArrayList<>(n);
         int ans = -1;

         if (connections.length < n - 1) return -1;

         for (int i = 0; i < n; ++i) {
             graph.add(new ArrayList<>());
         }

         for (int[] edge : connections) {
             int u = edge[0];
             int v = edge[1];
             graph.get(u).add(v);
             graph.get(v).add(u);
         }

         for (int i = 0; i < n; ++i) {
             if (!visited[i]) {
                 dfs(i, visited, graph);
                 ++ans;
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
            int[][] connections = new int[n][2];
            for (int i = 0; i < m; ++i) {
                connections[i][0] = sc.nextInt();
                connections[i][1] = sc.nextInt();
            }

            Solution solution = new Solution();
            System.out.print(solution.makeConnected(n, connections));
        }

        sc.close();
    }
}
