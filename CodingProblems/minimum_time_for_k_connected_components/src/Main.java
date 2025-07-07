import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution {
    private int n;
    private int[][] edges;
    private int k;
    private List<List<Integer>> graph;
    private boolean[] visited;

    public int minTime(final int n, final int[][] edges, final int k) {
        this.n = n;
        this.edges = edges;
        this.k = k;
        int left = 0;
        int right = (int) 1e9;
        int answer = -1;

        while (left <= right) {
            int mid = (left + ((right - left) >> 1));
            if (check(mid)) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return answer;
    }

    private boolean check(final int time) {
        graph = new ArrayList<>();
        visited = new boolean[n];
        int componentCount = 0;

        for (int i = 0; i < n; ++i) {
            graph.add(new ArrayList<>());
        }

        for (final int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int remTime = edge[2];
            if (remTime > time) {
                graph.get(u).add(v);
                graph.get(v).add(u);
            }
        }

        for (int i = 0; i < n; ++i) {
            if (!visited[i]) {
                ++componentCount;
                if (componentCount == k) {
                    return true;
                }
                dfs(i);
            }
        }

        return false;
    }

    private void dfs(final int node) {
        visited[node] = true;

        for (final int child : graph.get(node)) {
            if (!visited[child]) {
                dfs(child);
            }
        }
    }
}

public class Main {
   public static void main(String[] args) {
       final Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           final int n = scanner.nextInt();
           final int m = scanner.nextInt();
           final int[][] edges = new int[m][3];
           for (int i = 0; i < m; ++i) {
               edges[i][0] = scanner.nextInt();
               edges[i][1] = scanner.nextInt();
               edges[i][2] = scanner.nextInt();
           }
           final int k = scanner.nextInt();

           System.out.println(new Solution().minTime(n, edges, k));
       }
       
       scanner.close();
   }
}
