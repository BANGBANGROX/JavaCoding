// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int n = Integer.parseInt(read.readLine());
            n=n-1;
            ArrayList<Integer>[] graph = new ArrayList[n];
            while(n-- > 0){
                String[] input = new String[2];
                input = read.readLine().split(" ");
                int u = Integer.parseInt(input[0]);
                int v = Integer.parseInt(input[1]);
                graph[u].add(v);
                graph[v].add(u);
            }
            Solution ob = new Solution();
            System.out.println(ob.countOfNodes(graph, n));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution
{
    private ArrayList<Integer>[] graph;

    private void dfs(int node, int parent, int[] levels, int level) {
        ++levels[level];

        for (int child : graph[node]) {
            if (child != parent) dfs(child, node, levels, level + 1);
        }
    }

    public int countOfNodes(ArrayList<Integer> graph[], int n) {
        // code here
        this.graph = graph;
        int[] levels = new int[n];
        int ans = 0;
        int evenSum = 0;
        int oddSum = 0;

        dfs(1, -1, levels, 0);

        for (int i = 0; i < n; ++i) {
            ans += levels[i] * (levels[i] - 1) / 2;
        }

        for (int i = n - 1; i >= 0; --i) {
            if ((i & 1) > 0) {
                ans += levels[i] * oddSum;
                oddSum += levels[i];
            }
            else {
                ans += levels[i] * evenSum;
                evenSum += levels[i];
            }
        }

        return ans;
    }
}