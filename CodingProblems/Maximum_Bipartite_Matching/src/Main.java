//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] S = br.readLine().trim().split(" ");
            int m = Integer.parseInt(S[0]);
            int n = Integer.parseInt(S[1]);
            int[][] G = new int[m][n];
            for (int i = 0; i < m; i++) {
                String[] s = br.readLine().trim().split(" ");
                for (int j = 0; j < n; j++)
                    G[i][j] = Integer.parseInt(s[j]);
            }
            Solution obj = new Solution();
            int ans = obj.maximumMatch(G);
            out.println(ans);
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    private boolean[] visited;
    private int[] job;
    private int[][] graph;
    private int n;

    private boolean dfs(int node) {
        for (int i = 0; i < n; ++i) {
            if (graph[node][i] == 1 && !visited[i]) {
                visited[i] = true;
                if (job[i] == -1 || dfs(job[i])) {
                    job[i] = node;
                    return true;
                }
            }
        }

        return false;
    }

    public int maximumMatch(int[][] graph) {
        // Code here
        int m = graph.length;
        n = graph[0].length;
        job = new int[n];
        this.graph = graph;
        int ans = 0;

        Arrays.fill(job, -1);

        for (int i = 0; i < m; ++i) {
            visited = new boolean[n];
            if (dfs(i)) ++ans;
        }

        return ans;
    }
}