// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static PrintWriter ot;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        ot = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int[][] edges = new int[n - 1][];
            for (int i = 0; i < n - 1; i++) {
                s = br.readLine().trim().split(" ");
                int u = Integer.parseInt(s[0]);
                int v = Integer.parseInt(s[1]);
                edges[i] = new int[]{u, v};
            }
            ot.println(new Solution().maxPower(n, edges));
        }

        ot.close();
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
    private final ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
    private long[] dp;
    private long[] size;
    private int ans;
    private long maxValue;

    private void dfs1(int node, int parent) {
        size[node] = node;

        for (int child : tree.get(node)) {
            if (child != parent) {
                dfs1(child, node);
                size[node] += size[child];
                dp[node] += (dp[child] + size[child]);
            }
        }
    }

    private void dfs2(int node, int parent) {
        if (dp[node] >= maxValue) {
            if (dp[node] == maxValue) ans = Math.min(ans, node);
            else {
                ans = node;
                maxValue = dp[node];
            }
        }

        for (int child : tree.get(node)) {
            if (child != parent) {
                size[node] -= size[child];
                dp[node] -= (dp[child] + size[child]);
                size[child] += size[node];
                dp[child] += (dp[node] + size[node]);
                dfs2(child, node);
                size[child] -= size[node];
                dp[child] -= (dp[node] + size[node]);
                size[node] += size[child];
                dp[node] += (dp[child] + size[child]);
            }
        }
    }

    public int maxPower(int n, int[][] edges) {
        // Code Here.
        dp = new long[n];
        size = new long[n];
        ans = -1;
        maxValue = -1;

        for (int i = 0; i < n; ++i) {
            tree.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            tree.get(u).add(v);
            tree.get(v).add(u);
        }

        dfs1(0, -1);
        dfs2(0, -1);

        return ans;
    }
}