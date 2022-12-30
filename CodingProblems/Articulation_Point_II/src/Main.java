//{ Driver Code Starts
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
            int[] ans = obj.articulationPoints(V, adj);
            for (int i : ans)
                System.out.print(i + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


class Solution {
    private ArrayList<ArrayList<Integer>> graph;
    private HashSet<Integer> articulationPoints;
    private int[] inTime;
    private int[] lowTime;
    private boolean[] visited;
    private int timer;

    private void dfs(int node, int parent) {
        inTime[node] = lowTime[node] = timer;
        visited[node] = true;
        int children = 0;

        ++timer;

        for (int child : graph.get(node)) {
            if (child == parent) continue;
            else if (visited[child]) {
                lowTime[node] = Math.min(lowTime[node], inTime[child]);
            } else {
                ++children;
                dfs(child, node);
                lowTime[node] = Math.min(lowTime[node], lowTime[child]);
                if (lowTime[child] >= inTime[node] && parent != -1) {
                    articulationPoints.add(node);
                }
            }
        }

        if (children > 1 && parent == -1) articulationPoints.add(node);
    }

    public int[] articulationPoints(int n, ArrayList<ArrayList<Integer>> graph) {
        // Code here
        visited = new boolean[n];
        inTime = new int[n];
        lowTime = new int[n];
        this.graph = graph;
        articulationPoints = new HashSet<>();
        timer = 0;

        for (int i = 0; i < n; ++i) {
            if (!visited[i]) dfs(i, -1);
        }

        if (articulationPoints.isEmpty()) articulationPoints.add(-1);

        ArrayList<Integer> ans = new ArrayList<>(articulationPoints);

        Collections.sort(ans);

        return ans.stream().mapToInt(a -> a).toArray();
    }
}