//{ Driver Code Starts

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t=scanner.nextInt();
        while(t-- > 0)
        {
            int n = scanner.nextInt();
            int m = scanner.nextInt();

            ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                int u = scanner.nextInt();
                int v = scanner.nextInt();
                ArrayList<Integer> edge = new ArrayList<>();
                edge.add(u);
                edge.add(v);
                edges.add(edge);
            }

            Solution solution = new Solution();
            boolean result = solution.isTree(n, edges);

            if (result) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    private ArrayList<ArrayList<Integer>> graph;
    private boolean[] visited;

    private boolean hasCycle(int node, int parent) {
        visited[node] = true;

        for (int child : graph.get(node)) {
            if (!visited[child]) {
                if (hasCycle(child, node)) return true;
            }
            else if (visited[child] && child != parent) return true;
        }

        return false;
    }

    public boolean isTree(int n, ArrayList<ArrayList<Integer>> edges) {
        // code here
        graph = new ArrayList<>();
        visited = new boolean[n];

        for (int i = 0; i < n; ++i) {
            graph.add(new ArrayList<>());
        }

        for (ArrayList<Integer> edge : edges) {
            graph.get(edge.get(0)).add(edge.get(1));
            graph.get(edge.get(1)).add(edge.get(0));
        }

        if (hasCycle(0, -1)) return false;

        for (int i = 0; i < n; ++i) {
            if (!visited[i]) return false;
        }

        return true;
    }
}

