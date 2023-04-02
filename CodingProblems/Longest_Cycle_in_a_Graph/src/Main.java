import java.util.HashMap;
import java.util.Scanner;

class Solution {
    private HashMap<Integer, Integer> distance;
    private boolean[] visited;
    private int[] edges;
    private int ans;

    private void dfs(int node) {
        visited[node] = true;
        int child = edges[node];

        if (child == -1) return;

        if (!visited[child]) {
            distance.put(child, distance.get(node) + 1);
            dfs(child);
        }
        else if (visited[child] && distance.containsKey(child)) {
            ans = Math.max(ans, distance.get(node) - distance.get(child) + 1);
        }
    }

    public int longestCycle(int[] edges) {
         this.edges = edges;
         int n = edges.length;
         visited = new boolean[n];
         ans = -1;

         for (int i = 0; i < n; ++i) {
             if (!visited[i]) {
                 distance = new HashMap<>();
                 distance.put(i, 1);
                 dfs(i);
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
            int[] edges = new int[n];
            for (int i = 0; i < n; ++i) {
                edges[i] = sc.nextInt();
            }

            Solution solution = new Solution();
            System.out.println(solution.longestCycle(edges));
        }

        sc.close();
    }
}
