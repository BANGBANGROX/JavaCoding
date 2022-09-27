import java.util.Scanner;

class Solution {
    private static class UnionFind {
        public int[] parent;
        public int[] rank;

        UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; ++i) {
                parent[i] = i;
            }
        }

        public int find(int node) {
            if (node == parent[node]) return node;

            return parent[node] = find(parent[node]);
        }

        public boolean union(int p, int q) {
            int x = find(p);
            int y = find(q);

            if (x == y) return false;

            if (rank[x] > rank[y]) {
                parent[y] = x;
            }
            else {
                parent[x] = y;
                if (rank[x] == rank[y]) ++rank[x];
            }

            return true;
        }
    }

    public int[] findRedundantConnection(int[][] edges) {
       int n = edges.length;
       UnionFind unionFind = new UnionFind(n);

       for (int[] edge: edges) {
           int u = edge[0] - 1;
           int v = edge[1] - 1;
           if (!unionFind.union(u, v)) return edge;
       }

       return new int[]{};
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            int[][] edges = new int[n][2];
            for (int i = 0; i < n; ++i) {
                edges[i][0] = sc.nextInt();
                edges[i][1] = sc.nextInt();
            }

            Solution solution = new Solution();
            int[] ans = solution.findRedundantConnection(edges);
            assert ans.length > 1;
            System.out.println(ans[0] + " " + ans[1]);
        }

        sc.close();
    }
}
