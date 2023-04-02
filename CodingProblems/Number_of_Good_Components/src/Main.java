//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int E = Integer.parseInt(s[0]);
            int V = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i <= V; i++) adj.add(i, new ArrayList<>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            int ans = obj.findNumberOfGoodComponent(V, adj);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    private ArrayList<ArrayList<Integer>> graph;
    private boolean[] visited;
    private int compSize;
    private int edgeCount;

    private void dfs(int node, int parent) {
        ++compSize;
        visited[node] = true;

        for (int child : graph.get(node)) {
            if (!visited[child]) {
                ++edgeCount;
                dfs(child, node);
            }
            else if (child != parent) {
                ++edgeCount;
            }
        }
    }

    public int findNumberOfGoodComponent(int n, ArrayList<ArrayList<Integer>> graph) {
        // Code here
        this.graph = graph;
        visited = new boolean[n + 1];
        int ans = 0;

        for (int i = 1; i <= n; ++i) {
            if (!visited[i]) {
                compSize = edgeCount = 0;
                dfs(i, -1);
                edgeCount -= (compSize - 2) * (compSize - 1) / 2;
                if (edgeCount == compSize * (compSize - 1) / 2) {
                    ++ans;
                }
            }
        }

        return ans;
    }
}