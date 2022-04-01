import java.util.*;

class Solution {
    private LinkedList<Integer> currentPath;
    private List<List<Integer>> ans;
    private int n;

    private void allPathsSourceTarget(int[][] graph, int node) {
        if (node == n - 1) {
            currentPath.add(n - 1);
            ans.add(new ArrayList<>(currentPath));
            currentPath.removeLast();
            return;
        }

        currentPath.add(node);

        for (int child : graph[node]) {
            allPathsSourceTarget(graph, child);
        }

        currentPath.removeLast();
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        currentPath = new LinkedList<>();
        ans = new ArrayList<>();
        n = graph.length;

        allPathsSourceTarget(graph, 0);

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
            System.out.print(solution.allPathsSourceTarget(graph));
        }

        sc.close();
    }
}
