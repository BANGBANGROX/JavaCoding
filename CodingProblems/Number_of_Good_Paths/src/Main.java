import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;

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

        public int find(int x) {
            if (parent[x] == x) return x;

            return parent[x] = find(parent[x]);
        }

        public void union(int p, int q) {
            int parentP = find(p);
            int parentQ = find(q);

            if (rank[parentP] > rank[parentQ]) {
                parent[parentQ] = parentP;
            }
            else {
                parent[parentP] = parentQ;
                if (rank[parentP] == rank[parentQ]) ++rank[parentP];
            }
        }
    }

    public int numberOfGoodPaths(int[] values, int[][] edges) {
       int ans = 0;
       int n = values.length;
       TreeMap<Integer, ArrayList<Integer>> sameValues = new TreeMap<>();
       ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
       UnionFind unionFind = new UnionFind(n);

       for (int i = 0; i < n; ++i) {
           if (!sameValues.containsKey(values[i]))
               sameValues.put(values[i], new ArrayList<>());
           sameValues.get(values[i]).add(i);
           graph.add(new ArrayList<>());
       }

       for (int[] edge: edges) {
           int u = edge[0];
           int v = edge[1];
           if (values[u] >= values[v]) graph.get(u).add(v);
           else graph.get(v).add(u);
       }

       for (int val: sameValues.keySet()) {
           ArrayList<Integer> list = sameValues.get(val);
           for (int node: list) {
               for (int child: graph.get(node)) {
                   unionFind.union(node, child);
               }
           }
           HashMap<Integer, Integer> count = new HashMap<>();
           for (int node: list) {
               int find = unionFind.find(node);
               count.put(find, count.getOrDefault(find, 0) + 1);
           }
           ans += list.size();
           for (int x: count.keySet()) {
               int size = count.get(x);
               ans += size * (size - 1) / 2;
           }
       }

       return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            int[] values = new int[n];
            for (int i = 0; i < n; ++i) {
                values[i] = sc.nextInt();
            }
            int[][] edges = new int[n - 1][2];
            for (int i = 0; i < n - 1; ++i) {
                edges[i][0] = sc.nextInt();
                edges[i][1] = sc.nextInt();
            }

            Solution solution = new Solution();
            System.out.println(solution.numberOfGoodPaths(values, edges));
        }

        sc.close();
    }
}
