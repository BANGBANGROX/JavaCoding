import java.util.ArrayList;
import java.util.Scanner;

class Solution {
    private int[] ans;
    private final ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    private String labels;

    private int[] dfs(int node, int parent) {
        ++ans[node];
        int[] nextResult = new int[26];

        nextResult[labels.charAt(node) - 'a'] = 1;

        for (int child : graph.get(node)) {
            if (child != parent) {
                int[] result = dfs(child, node);
                ans[node] += result[labels.charAt(node) - 'a'];
                for (int i = 0; i < 26; ++i) {
                    nextResult[i] += result[i];
                }
            }
        }

        return nextResult;
    }

    public int[] countSubTrees(int n, int[][] edges, String labels) {
        ans = new int[n];
        this.labels = labels;

        for (int i = 0; i < n; ++i) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        dfs(0, -1);

        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            int[][] edges = new int[n - 1][2];
            for (int i = 1; i < n; ++i) {
                edges[i - 1][0] = sc.nextInt();
                edges[i - 1][1] = sc.nextInt();
            }
            String labels = sc.next();

            Solution solution = new Solution();
            int[] ans = solution.countSubTrees(n, edges, labels);
            for (int x : ans) {
                System.out.print(x + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}
