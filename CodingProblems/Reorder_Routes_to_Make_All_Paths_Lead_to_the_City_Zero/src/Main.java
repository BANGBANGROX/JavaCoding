import java.util.*;

class Solution {
    public int minReorder(int n, int[][] connections) {
        List<List<Integer>> graph = new ArrayList<>(n);
        List<List<Integer>> reverseGraph = new ArrayList<>(n);
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n];
        int ans = 0;

        for (int i = 0; i < n; ++i) {
            graph.add(new ArrayList<>());
            reverseGraph.add(new ArrayList<>());
        }

        for (int[] edge : connections) {
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            reverseGraph.get(v).add(u);
        }

        q.add(0);
        visited[0] = true;

        while (!q.isEmpty()) {
            int node = q.poll();
            for (int child : graph.get(node)) {
                if (!visited[child]) {
                    visited[child] = true;
                    q.add(child);
                    ++ans;
                }
            }
            for (int child : reverseGraph.get(node)) {
                if (!visited[child]) {
                    visited[child] = true;
                    q.add(child);
                }
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
