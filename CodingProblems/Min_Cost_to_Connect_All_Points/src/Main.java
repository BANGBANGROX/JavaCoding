import java.util.*;

class Solution {
    private static class UnionFind {
        private final int[] parent;
        private final int[] rank;

        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; ++i) {
                parent[i] = i;
            }
        }

        public int find(int node) {
            if (parent[node] != node) return parent[node] = find(parent[node]);

            return node;
        }

        public boolean union(int node1, int node2) {
            int parent1 = find(node1);
            int parent2 = find(node2);

            if (parent1 == parent2) return false;

            if (rank[parent1] > rank[parent2]) {
                parent[parent2] = parent1;
                rank[parent1] += rank[parent2];
            }
            else if (rank[parent1] < rank[parent2]) {
                parent[parent1] = parent2;
                rank[parent2] += rank[parent1];
            }
            else {
                parent[parent1] = parent2;
                rank[parent2] += rank[parent1];
            }

            return true;
        }
    }

    public int minCostConnectPoints(int[][] points) {
           int ans = 0;
           int n = points.length;
           int edges = 0;
           ArrayList<int[]> allEdges = new ArrayList<>();
           UnionFind unionFind = new UnionFind(n);

           for (int i = 0; i < n; ++i) {
               for (int j = i + 1; j < n; ++j) {
                   int weight = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                   allEdges.add(new int[]{i, j, weight});
               }
           }

          allEdges.sort(Comparator.comparingInt(a -> a[2]));

          for (int i = 0; i < allEdges.size() && edges < n - 1; ++i) {
              int node1 = allEdges.get(i)[0];
              int node2 = allEdges.get(i)[1];
              int weight = allEdges.get(i)[2];
              if (unionFind.union(node1, node2)) {
                  ++edges;
                  ans += weight;
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
            int[][] points = new int[n][2];
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < 2; ++j) {
                    points[i][j] = sc.nextInt();
                }
            }

            Solution solution = new Solution();
            System.out.println(solution.minCostConnectPoints(points));
        }

        sc.close();
    }
}
