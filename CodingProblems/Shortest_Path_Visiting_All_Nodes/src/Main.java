import java.util.*;

class Solution {
    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        int steps = 0;
        int endingMask = (1 << n) - 1;
        boolean[][] visited = new boolean[n][endingMask + 1];
        Queue<ArrayList<Integer>> q = new LinkedList<>();

        for (int i = 0; i < n; ++i) {
            q.add(new ArrayList<>(Arrays.asList(i, (1 << i))));
            visited[i][1 << i] = true;
        }

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; ++i) {
                ArrayList<Integer> currentState = q.poll();
                assert currentState != null;
                int node = currentState.get(0);
                int mask = currentState.get(1);
                for (int child : graph[node]) {
                    int newMask = mask | (1 << child);
                    if (newMask == endingMask) return 1 + steps;
                    if (!visited[child][newMask]) {
                        q.add(new ArrayList<>(Arrays.asList(child, newMask)));
                        visited[child][newMask] = true;
                    }
                }
            }
            ++steps;
        }

        return 0;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            int[][] graph = new int[n][n];
            for (int i = 0; i < n; ++i) {
                int m = sc.nextInt();
                for (int j = 0; j < m; ++j) {
                    graph[i][j] = sc.nextInt();
                }
            }

            Solution solution = new Solution();
            System.out.println(solution.shortestPathLength(graph));
        }

        sc.close();
    }
}
