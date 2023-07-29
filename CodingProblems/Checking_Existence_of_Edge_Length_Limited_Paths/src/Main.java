import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Solution {
    private static class UnionFind {
        private final int[] parent;
        private final int[] rank;

        UnionFind(int size) {
            parent = new int[size];
            rank = new int[size];

            for (int i = 0; i < size; ++i) {
                parent[i] = i;
            }
        }

        private int findParent(int node) {
            if (parent[node] == node) return node;

            return parent[node] = findParent(parent[node]);
        }

        public void joinGroups(int node1, int node2) {
            int parent1 = findParent(node1);
            int parent2 = findParent(node2);

            if (parent1 == parent2) return;

            if (rank[parent1] > rank[parent2]) {
                parent[parent2] = parent1;
            }
            else if (rank[parent1] < rank[parent2]) {
                parent[parent1] = parent2;
            }
            else {
                parent[parent1] = parent2;
                ++rank[parent2];
            }
        }

        public boolean isSameGroup(int node1, int node2) {
            return findParent(node1) == findParent(node2);
        }
    }

    private void sort(int[][] array) {
        Arrays.sort(array, Comparator.comparingInt(a -> a[2]));
    }

    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
         int queriesCount = queries.length;
         int edgeIndex = 0;
         int edgesCount = edgeList.length;
         boolean[] answer = new boolean[queriesCount];
         int[][] indexedQueries = new int[queriesCount][];
         UnionFind unionFind = new UnionFind(n);

         for (int i = 0; i < queriesCount; ++i) {
             indexedQueries[i] = new int[]{queries[i][0], queries[i][1], queries[i][2], i};
         }

         sort(edgeList);
         sort(indexedQueries);

         for (int i = 0; i < queriesCount; ++i) {
             int node1 = indexedQueries[i][0];
             int node2 = indexedQueries[i][1];
             int weightUpperLimit = indexedQueries[i][2];
             int queryIndex = indexedQueries[i][3];
             while (edgeIndex < edgesCount && edgeList[edgeIndex][2] < weightUpperLimit) {
                 int p = edgeList[edgeIndex][0];
                 int q = edgeList[edgeIndex][1];
                 unionFind.joinGroups(p, q);
                 ++edgeIndex;
             }
             answer[queryIndex] = unionFind.isSameGroup(node1, node2);
         }

         return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            int edgesCount = sc.nextInt();
            int[][] edgeList = new int[n][3];
            for (int i = 0; i < edgesCount; ++i) {
                edgeList[i][0] = sc.nextInt();
                edgeList[i][1] = sc.nextInt();
                edgeList[i][2] = sc.nextInt();
            }
            int queriesCount = sc.nextInt();
            int[][] queries = new int[n][3];
            for (int i = 0; i < queriesCount; ++i) {
                queries[i][0] = sc.nextInt();
                queries[i][1] = sc.nextInt();
                queries[i][2] = sc.nextInt();
            }

            Solution solution = new Solution();
            boolean[] answer = solution.distanceLimitedPathsExist(n, edgeList, queries);
            for (boolean x : answer) {
                System.out.print(x + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}
