//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            int[][] edge = new int[N - 1][2];
            for (int i = 0; i < N - 1; i++) {
                String[] input = read.readLine().trim().split("\\s+");
                edge[i][0] = Integer.parseInt(input[0]);
                edge[i][1] = Integer.parseInt(input[1]);
            }
            Solution ob = new Solution();
            out.println(ob.countVertex(N, edge));
        }
        out.close();
    }
}


// } Driver Code Ends
//User function Template for Java

class Solution {
    private int[][] dp;
    private ArrayList<ArrayList<Integer>> tree;

    private void dfs(int node, int parent) {
        ++dp[node][1];

        for (int child : tree.get(node)) {
            if (child != parent) {
                dfs(child, node);
                dp[node][0] += dp[child][1];
                dp[node][1] += Math.min(dp[child][1], dp[child][0]);
            }
        }
    }

    public int countVertex(int n, int[][] edges) {
        // code here
        tree = new ArrayList<>();
        dp = new int[n][2];

        for (int i = 0; i < n; ++i) {
            tree.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0] - 1;
            int v = edge[1] - 1;
            tree.get(u).add(v);
            tree.get(v).add(u);
        }

        dfs(0, -1);

        return Math.min(dp[0][1], dp[0][0]);
    }
}

//{ Driver Code Starts.

// } Driver Code Ends