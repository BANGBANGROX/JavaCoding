import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

class Solution {
    private static class pair {
        long first;
        int second;

        pair(long first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    private long[] dijkstra(int n, ArrayList<ArrayList<pair>> graph, int src) {
        TreeSet<pair> s = new TreeSet<>();
        long[] distance = new long[n];

        for (int i = 0; i < n; ++i) {
            distance[i] = Long.MAX_VALUE;
        }

        distance[src] = 0;
        s.add(new pair(distance[src], src));

        while (!s.isEmpty()) {
            pair currentNode = s.pollFirst();
            assert currentNode != null;
            int node = currentNode.second;
            for (pair childNode : graph.get(node)) {
                int child = childNode.second;
                long wt = childNode.first;
                if (distance[child] > distance[node] + wt) {
                    s.remove(new pair(distance[child], child));
                    distance[child] = distance[node] + wt;
                    s.add(new pair(distance[child], child));
                }
            }
        }

        return distance;
    }

    public long minimumWeight(int n, int[][] edges, int src1, int src2, int dest) {
          ArrayList<ArrayList<pair>> graph = new ArrayList<>();
          ArrayList<ArrayList<pair>> reversedGraph = new ArrayList<>();

          for (int i = 0; i < n; ++i) {
             graph.add(new ArrayList<>());
             reversedGraph.add(new ArrayList<>());
          }

          for (int[] edge : edges) {
              int u = edge[0];
              int v = edge[1];
              int wt = edge[2];
              graph.get(u).add(new pair(wt, v));
              reversedGraph.get(v).add(new pair(wt, u));
          }

          long[] distanceFromSrc1 = dijkstra(n, graph, src1);
          long[] distanceFromSrc2 = dijkstra(n, graph, src2);
          long[] distanceFromDest = dijkstra(n, reversedGraph, dest);
          long ans = Long.MAX_VALUE;

          for (int i = 0; i < n; ++i) {
              if (distanceFromDest[i] != Long.MAX_VALUE && distanceFromSrc1[i] != Long.MAX_VALUE &&
                      distanceFromSrc2[i] != Long.MAX_VALUE) {
                  ans = Math.min(ans, distanceFromSrc1[i] + distanceFromSrc2[i] + distanceFromDest[i]);
              }
          }

          return ans == Long.MAX_VALUE ? -1 : ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] edges = new int[m][3];
            for (int i = 0; i < m; ++i) {
                edges[i][0] = sc.nextInt();
                edges[i][1] = sc.nextInt();
                edges[i][2] = sc.nextInt();
            }
            int src1 = sc.nextInt();
            int src2 = sc.nextInt();
            int dest = sc.nextInt();

            Solution solution = new Solution();
            System.out.println(solution.minimumWeight(n, edges, src1, src2, dest));
        }

        sc.close();
    }
}
