import java.util.*;

class Solution {
    private List<Integer>[] graph;
    private boolean[] color;
    private boolean[] visited;

    private boolean isNotBipartite(int node) {
        visited[node] = true;

        for (int child : graph[node]) {
            if (!visited[child]) {
                color[child] = !color[node];
                if (isNotBipartite(child)) return true;
            }
            else if (color[child] == color[node]) return true;
        }

        return false;
    }

    public boolean possibleBipartition(int n, int[][] dislikes) {
        graph = new List[n];
        visited = new boolean[n];
        color = new boolean[n];

        for (int i = 0; i < n; ++i) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : dislikes) {
            int u = edge[0];
            int v = edge[1];
            graph[u].add(v);
            graph[v].add(u);
        }

        for (int i = 0; i < n; ++i) {
            if (!visited[i] && isNotBipartite(i)) return false;
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
            int m = sc.nextInt();
            int[][] dislikes = new int[m][2];
            for (int i = 0; i < m; ++i) {
                dislikes[i][0] = sc.nextInt();
                dislikes[i][1] = sc.nextInt();
            }

            Solution solution = new Solution();
            System.out.println(solution.possibleBipartition(n, dislikes));
        }

        sc.close();
    }
}
