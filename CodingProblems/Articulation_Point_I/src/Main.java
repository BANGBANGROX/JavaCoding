//{ Driver Code Starts
// Initial Template for Java
import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>>adj = new ArrayList<>();
            for(int i = 0; i < V; i++)
                adj.add(i, new ArrayList<>());
            for(int i = 0; i < E; i++){
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            ArrayList<Integer>ans = obj.articulationPoints(V, adj);
            for (Integer an : ans) System.out.print(an + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    private boolean[] visited;
    private int[] inTime;
    private int[] lowTime;
    private Set<Integer> pts;
    private ArrayList<ArrayList<Integer>> graph;
    private int timer;

    private void dfs(int node, int parent) {
        visited[node] = true;
        inTime[node] = lowTime[node] = timer;
        int children = 0;

        ++timer;

        for (int child : graph.get(node)) {
            if (child == parent) {
                continue;
            }
            else if (visited[child]) {
                lowTime[node] = Math.min(lowTime[node], inTime[child]);
            }
            else {
                dfs(child, node);
                ++children;
                lowTime[node] = Math.min(lowTime[node], lowTime[child]);
                if (lowTime[child] >= inTime[node] && parent != -1) {
                    pts.add(node);
                }
            }
        }

        if (parent == -1 && children > 1) {
            pts.add(node);
        }
    }

    //Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> articulationPoints(int n, ArrayList<ArrayList<Integer>> graph) {
        // Code here
        this.graph = graph;
        inTime = new int[n];
        lowTime = new int[n];
        visited = new boolean[n];
        timer = 0;
        pts = new HashSet<>();

        for (int i = 0; i < n; ++i) {
            if (!visited[i]) {
                dfs(i, -1);
            }
        }

        ArrayList<Integer> ans = new ArrayList<>(pts);

        if (ans.isEmpty()) ans.add(-1);

        Collections.sort(ans);

        return ans;
    }
}