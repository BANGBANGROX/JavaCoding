//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0){
            int n = Integer.parseInt(read.readLine());

            int[][] edges = new int[n-1][3];
            for(int i = 0; i < (n-1); i++){
                String[] input_line = read.readLine().trim().split("\\s+");
                for(int j = 0; j < 3; j++){
                    edges[i][j] = Integer.parseInt(input_line[j]);
                }
            }

            int q = Integer.parseInt(read.readLine());

            String[] input_line = read.readLine().trim().split("\\s+");
            int[] queries = new int[q];
            for(int i = 0; i < q; i++)
                queries[i] = Integer.parseInt(input_line[i]);

            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.maximumWeight(n, edges, q, queries);
            for (Integer val: ans)
                System.out.print(val+" ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    private static class UnionFind {
        private final int[] parent;
        private final int[] size;

        UnionFind(int n) {
            parent = new int[n];
            size = new int[n];

            for (int i = 0; i < n; ++i) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int getNodeSize(int node) {
            return size[node];
        }

        public int getNodeParent(int node) {
            if (parent[node] == node) return node;

            return parent[node] = getNodeParent(parent[node]);
        }

        public void computeUnion(int node1, int node2) {
            int parent1 = getNodeParent(node1);
            int parent2 = getNodeParent(node2);

            if (parent1 == parent2) return;

            if (size[parent1] > size[parent2]) {
                parent[parent2] = parent1;
                size[parent1] += size[parent2];
            }
            else {
                parent[parent1] = parent2;
                size[parent2] += size[parent1];
            }
        }
    }

    private int getUpperBoundWeightIndex(int[][] edges, int weight) {
        int l = 0;
        int r = edges.length - 1;
        int answer = r + 1;

        while (l <= r) {
            int mid = (l + ((r - l) >> 1));
            if (edges[mid][2] <= weight) {
                l = mid + 1;
            }
            else {
                r = mid - 1;
                answer = mid;
            }
        }

        return answer;
    }

    public ArrayList<Integer> maximumWeight(int n, int[][] edges, int q, int[] queries) {
        // code here
        ArrayList<Integer> answer = new ArrayList<>();
        UnionFind unionFind = new UnionFind(n);
        int edgeCount = n - 1;
        ArrayList<Integer> edgeSize = new ArrayList<>();

        Arrays.sort(edges, Comparator.comparingInt(a -> a[2]));

        for (int i = 0; i < edgeCount; ++i) {
            int[] edge = edges[i];
            int u = edge[0] - 1;
            int v = edge[1] - 1;
            int parent1 = unionFind.getNodeParent(u);
            int parent2 = unionFind.getNodeParent(v);
            if (parent1 != parent2) {
                edgeSize.add(unionFind.getNodeSize(parent1) * unionFind.getNodeSize(parent2));
                unionFind.computeUnion(parent1, parent2);
            }
        }

        for (int i = 1; i < edgeSize.size(); ++i) {
            edgeSize.set(i, edgeSize.get(i - 1) + edgeSize.get(i));
        }

        // System.out.println(edgeSize);

        for (int i = 0; i < q; ++i) {
            int weight = queries[i];
            int idx = getUpperBoundWeightIndex(edges, weight);
            answer.add(idx != 0 ? edgeSize.get(idx - 1) : 0);
        }

        return answer;
    }
}