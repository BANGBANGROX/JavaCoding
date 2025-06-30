import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Solution {
    private int[][] edges;
    private int n;
    private int k;

    private static class DisjointSetUnion {
        private final int[] parent;
        private final int[] rank;

        public DisjointSetUnion(final int n) {
            parent = new int[n];
            rank = new int[n];

            for (int i = 0; i < n; ++i) {
                parent[i] = i;
            }
        }

        public int find(final int node) {
            if (parent[node] == node) {
                return node;
            }

            return parent[node] = find(parent[node]);
        }

        public boolean union(final int u, final int v) {
            final int uParent = find(u);
            final int vParent = find(v);

            if (uParent == vParent) {
                return false;
            }

            if (rank[uParent] > rank[vParent]) {
                parent[vParent] = uParent;
            } else {
                parent[uParent] = vParent;
                if (rank[uParent] == rank[vParent]) {
                    ++rank[vParent];
                }
            }

            return true;
        }
    }

    public int maxStability(final int n, final int[][] edges, final int k) {
        this.n = n;
        this.edges = edges;
        this.k = k;
        int left = 0;
        int right = (int) 3e5;
        int answer = -1;

        while (left <= right) {
            final int mid = (left + ((right - left) >> 1));
            if (check(mid)) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return answer;
    }

    private boolean check(final int stability) {
        final DisjointSetUnion disjointSetUnion = new DisjointSetUnion(n);
        final List<List<Integer>> candidateEdges = new ArrayList<>();
        int edgeIncluded = 0;
        int totalCost = 0;

        for (final int[] edge : edges) {
            if (edge[3] == 1) {
                if (edge[2] < stability || !disjointSetUnion.union(edge[0], edge[1])) {
                    return false;
                } else {
                    ++edgeIncluded;
                }
            }
        }

        for (final int[] edge : edges) {
            if (edge[3] == 0) {
                if (edge[2] >= stability) {
                    candidateEdges.add(List.of(0, edge[0], edge[1]));
                } else if (edge[2] * 2 >= stability) {
                    candidateEdges.add(List.of(1, edge[0], edge[1]));
                }
            }
        }

        candidateEdges.sort(Comparator.comparingInt(List::getFirst));

        for (final List<Integer> edge : candidateEdges) {
            if (totalCost + edge.getFirst() <= k && disjointSetUnion.union(edge.get(1), edge.get(2))) {
                ++edgeIncluded;
                totalCost += edge.getFirst();
                if (edgeIncluded == n - 1) {
                    return true;
                }
            }
        }

        return edgeIncluded == n - 1;
    }
}

public class Main {
   public static void main(String[] args) {
       final Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           final int n = scanner.nextInt();
           final int m = scanner.nextInt();
           final int[][] edges = new int[m][4];
           for (int i = 0; i < m; ++i) {
               for (int j = 0; j < 4; ++j) {
                   edges[i][j] = scanner.nextInt();
               }
           }
           final int k = scanner.nextInt();

           System.out.println(new Solution().maxStability(n, edges, k));
       }
       
       scanner.close();
   }
}
