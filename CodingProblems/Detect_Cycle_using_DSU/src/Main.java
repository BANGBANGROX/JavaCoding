//{ Driver Code Starts
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
            int ans = obj.detectCycle(V, adj);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution {
    private static class UnionFind {
        private final int[] parent;
        private final int[] weight;

        UnionFind(int n) {
            parent = new int[n];
            weight = new int[n];

            for (int i = 0; i < n; ++i) {
                parent[i] = i;
                weight[i] = 1;
            }
        }

        public int findParent(int node) {
            if (parent[node] == node) return node;

            return parent[node] = findParent(parent[node]);
        }

        public boolean computeUnion(int node1, int node2) {
            int parent1 = findParent(node1);
            int parent2 = findParent(node2);

            if (parent1 == parent2) return false;

            if (weight[parent1] < weight[parent2]) {
                parent[parent1] = parent2;
                weight[parent2] += weight[parent1];
            } else {
                parent[parent2] = parent1;
                weight[parent1] += weight[parent2];
            }

            return true;
        }
    }

    //Function to detect cycle using DSU in an undirected graph.
    public int detectCycle(int n, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        UnionFind unionFind = new UnionFind(n);

        for (int i = 0; i < n; ++i) {
            for (int child : adj.get(i)) {
                if (i < child && !unionFind.computeUnion(i, child)) {
                    return 1;
                }
            }
        }

        return 0;
    }
}