import java.util.ArrayList;
import java.util.Scanner;

class Solution {
    private final ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    private boolean[] visited;
    private int compSize;

    private void dfs(int node) {
        visited[node] = true;
        ++compSize;

        for (int child : graph.get(node)) {
            if (!visited[child]) {
                dfs(child);
            }
        }
    }

    public long countPairs(int n, int[][] edges) {
        visited = new boolean[n];
        long ans = (long) n * (n - 1) / 2;

        for (int i = 0; i < n; ++i) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        for (int i = 0; i < n; ++i) {
            if (!visited[i]) {
                compSize = 0;
                dfs(i);
                ans -= (long) compSize * (compSize - 1) / 2;
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
            int[][] edges = new int[m][2];
            for (int i = 0; i < m; ++i) {
                edges[i][0] = sc.nextInt();
                edges[i][1] = sc.nextInt();
            }

            Solution solution = new Solution();
            System.out.println(solution.countPairs(n, edges));
        }

        sc.close();
    }
}
