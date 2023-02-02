//{ Driver Code Starts
//Initial Template for Java


import java.util.*;
import java.lang.*;
import java.io.*;


public class Main {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        Integer nextInt() {
            return Integer.parseInt(next());
        }

    }

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        int t = sc.nextInt();
        while (t-- > 0) {
            int N = sc.nextInt();
            int[] Edge = new int[N];
            for (int i = 0; i < N; i++)
                Edge[i] = sc.nextInt();
            Solution ob = new Solution();
            long ans = ob.largesSumCycle(N, Edge);
            out.println(ans);
        }
        out.flush();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    private int[] edge;
    private boolean[] visited;
    private boolean[] recStack;
    private long ans;

    private void dfs(int node) {
        visited[node] = true;
        recStack[node] = true;
        int child = edge[node];

        if (child != -1) {
            if (!visited[child]) {
                dfs(child);
            }
            else if (recStack[child]) {
                long current = 0;
                int temp = child;
                do {
                    current += temp;
                    temp = edge[temp];
                } while (temp != child);
                ans = Math.max(ans, current);
            }
        }

        recStack[node] = false;
    }

    public long largesSumCycle(int n, int[] edge) {
        this.edge = edge;
        recStack = new boolean[n];
        visited = new boolean[n];
        ans = -1;

        for (int i = 0; i < n; ++i) {
            if (!visited[i]) {
                dfs(i);
            }
        }

        return ans;
    }
}