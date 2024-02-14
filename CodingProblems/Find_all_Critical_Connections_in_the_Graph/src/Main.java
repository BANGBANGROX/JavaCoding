//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++)
                adj.add(i, new ArrayList<>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            ArrayList<ArrayList<Integer>> ans = obj.criticalConnections(V, adj);
            for (ArrayList<Integer> an : ans) System.out.println(an.get(0) + " " + an.get(1));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    private ArrayList<ArrayList<Integer>> answer;
    private ArrayList<ArrayList<Integer>> graph;
    private int[] discoveryTime;
    private int[] lowTime;
    private boolean[] visited;
    private int timer;

    private void findBridges(int node, int parent) {
        visited[node] = true;
        discoveryTime[node] = lowTime[node] = ++timer;

        for (int child : graph.get(node)) {
            if (child == parent) continue;
            if (visited[child]) {
                lowTime[node] = Math.min(lowTime[node], discoveryTime[child]);
            } else {
                findBridges(child, node);
                lowTime[node] = Math.min(lowTime[node], lowTime[child]);
                if (lowTime[child] > discoveryTime[node]) {
                    answer.add(new ArrayList<>(Arrays.asList(Math.min(node, child), Math.max(node, child))));
                }
            }
        }
    }

    public ArrayList<ArrayList<Integer>> criticalConnections(int n, ArrayList<ArrayList<Integer>> graph) {
        // Code here
        answer = new ArrayList<>();
        this.graph = graph;
        discoveryTime = new int[n];
        lowTime = new int[n];
        visited = new boolean[n];
        timer = 0;

        findBridges(0, -1);

        answer.sort((a, b) -> !Objects.equals(a.get(0), b.get(0)) ? a.get(0) - b.get(0) : a.get(1) - b.get(1));

        return answer;
    }
}