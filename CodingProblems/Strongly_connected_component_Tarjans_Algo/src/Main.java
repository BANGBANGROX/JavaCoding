//{ Driver Code Starts
// Initial Template for Java

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            // arraylist of arraylist to represent graph
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

            int V = Integer.parseInt(sc.next());
            int E = Integer.parseInt(sc.next());

            for (int i = 0; i < V; i++)
                adj.add(i, new ArrayList<>());

            for (int i = 1; i <= E; i++) {
                int u = Integer.parseInt(sc.next());
                int v = Integer.parseInt(sc.next());

                // adding directed edges between
                // vertex 'u' and 'v'
                adj.get(u).add(v);
            }

            Solution ob = new Solution();
            ArrayList<ArrayList<Integer>> ptr = ob.tarjans(V, adj);

            for (ArrayList<Integer> integers : ptr) {
                for (int j = 0; j < integers.size(); j++) {
                    if (j == integers.size() - 1)
                        System.out.print(integers.get(j));
                    else
                        System.out.print(integers.get(j) + " ");
                }
                System.out.print(",");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    private final ArrayList<Integer> currentComponent = new ArrayList<>();
    private ArrayList<ArrayList<Integer>> graph;
    private ArrayList<ArrayList<Integer>> inverseGraph;
    private boolean[] visited;
    private final Stack<Integer> st = new Stack<>();

    private void dfs1(int node) {
        visited[node] = true;

        for (int child : graph.get(node)) {
            if (!visited[child]) {
                dfs1(child);
            }
        }

        st.push(node);
    }

    private void dfs2(int node) {
        visited[node] = true;

        for (int child : inverseGraph.get(node)) {
            if (!visited[child]) {
                dfs2(child);
            }
        }

        currentComponent.add(node);
    }

    //Function to return a list of lists of integers denoting the members 
    //of strongly connected components in the given graph.  
    public ArrayList<ArrayList<Integer>> tarjans(int n,
                                                 ArrayList<ArrayList<Integer>> graph) {
        // code here
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        this.graph = graph;
        inverseGraph = new ArrayList<>();
        visited = new boolean[n];

        for (int i = 0; i < n; ++i) {
            if (!visited[i]) dfs1(i);
            inverseGraph.add(new ArrayList<>());
        }

        for (int i = 0; i < n; ++i) {
            visited[i] = false;
            for (int child : graph.get(i)) {
                inverseGraph.get(child).add(i);
            }
        }

        while (!st.isEmpty()) {
            int node = st.pop();
            if (visited[node]) continue;
            dfs2(node);
            Collections.sort(currentComponent);
            ans.add(new ArrayList<>(currentComponent));
            currentComponent.clear();
        }

        ans.sort((a, b) -> {
            int len = Math.min(a.size(), b.size());

            for (int i = 0; i < len; ++i) {
                if (a.get(i) < b.get(i)) return -1;
                else if (a.get(i) > b.get(i)) return 1;
            }

            return a.size() - b.size();
        });

        return ans;
    }
}