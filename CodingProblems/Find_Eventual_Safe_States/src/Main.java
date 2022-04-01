import java.util.*;

class Solution {
    private boolean[] visited;
    private boolean[] safeNode;

    private void dfs(int node, int[][] graph) {
        boolean isSafe = true;

        visited[node] = true;

        for (int child : graph[node]) {
            if (!visited[child]) {
                dfs(child, graph);
            }
            isSafe &= safeNode[child];
        }

        safeNode[node] = isSafe;
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<Integer> ans = new ArrayList<>();
        visited = new boolean[n];
        safeNode = new boolean[n];

        for (int i = 0; i < n; ++i) {
            if (!visited[i]) {
                dfs(i, graph);
            }
        }

        for (int i = 0; i < n; ++i) {
            if (safeNode[i]) ans.add(i);
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
            int[][] graph = new int[n][];
            for (int i = 0; i < n; ++i) {
                int m = sc.nextInt();
                graph[i] = new int[m];
                for (int j = 0; j < m; ++j) {
                    graph[i][j] = sc.nextInt();
                }
            }

            Solution solution = new Solution();
            System.out.print(solution.eventualSafeNodes(graph));
        }

        sc.close();
    }
}
