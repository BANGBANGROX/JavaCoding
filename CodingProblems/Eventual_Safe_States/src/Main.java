//{ Driver Code Starts
// Initial Template for Java

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

// Position this line where user code will be pasted.

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int V = sc.nextInt();
            int E = sc.nextInt();

            List<List<Integer>> adj = new ArrayList<>();

            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
            }
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();

                adj.get(u).add(v);
            }

            Solution obj = new Solution();
            List<Integer> safeNodes = obj.eventualSafeNodes(V, adj);
            for (int i : safeNodes) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    private final List<Integer> ans = new ArrayList<>();
    private List<List<Integer>> graph;
    private boolean[] visited;
    private boolean[] recStack;

    private boolean dfs(int node) {
        visited[node] = true;
        recStack[node] = true;

        for (int child : graph.get(node)) {
            if (!visited[child]) {
                if (!dfs(child)) {
                    return false;
                }
            }
            else if (recStack[child]) {
                return false;
            }
        }

        ans.add(node);

        recStack[node] = false;

        return true;
    }

    List<Integer> eventualSafeNodes(int n, List<List<Integer>> graph) {
        // Your code here
        visited = new boolean[n];
        recStack = new boolean[n];
        this.graph = graph;

        for (int i = 0; i < n; ++i) {
            if (!visited[i]) {
                dfs(i);
            }
        }

        Collections.sort(ans);

        return ans;
    }
}
