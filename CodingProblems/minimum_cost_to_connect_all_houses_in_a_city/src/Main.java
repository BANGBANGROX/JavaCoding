//{ Driver Code Starts

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[][] edge = new int[n][2];
            for (int i = 0; i < n; i++) {
                edge[i][0] = sc.nextInt();
                edge[i][1] = sc.nextInt();
            }
            Solution obj = new Solution();
            int res = obj.minCost(edge);

            System.out.println(res);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends




class Solution {
    private static class UnionFind {
        int[] parent;
        int[] size;

        public UnionFind(int n) {
            parent = new int[n];
            size = new int[n];

            for (int i = 0; i < n; ++i) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public boolean performUnion(int node1, int node2) {
            int par1 = find(node1);
            int par2 = find(node2);

            if (par1 == par2) {
                return false;
            }

            if (size[par1] > size[par2]) {
                parent[par2] = par1;
                size[par1] += size[par2];
            } else {
                parent[par1] = par2;
                size[par2] += size[par1];
            }

            return true;
        }

        private int find(int node) {
            if (parent[node] == node) return node;

            return parent[node] = find(parent[node]);
        }
    }

    public int minCost(int[][] houses) {
        // code here
        int n = houses.length;
        UnionFind unionFind = new UnionFind(n);
        List<List<Integer>> edges = new ArrayList<>();
        int answer = 0;

        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                int dis = Math.abs(houses[i][0] - houses[j][0]) + Math.abs(houses[i][1] - houses[j][1]);
                edges.add(List.of(dis, i, j));
            }
        }

        edges.sort(Comparator.comparingInt(List::getFirst));

        for (List<Integer> edge : edges) {
            int u = edge.get(1);
            int v = edge.get(2);
            if (unionFind.performUnion(u, v)) {
                answer += edge.getFirst();
            }
        }

        return answer;
    }
}
