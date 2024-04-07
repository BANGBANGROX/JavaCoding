import java.util.Scanner;

class Solution {
    private static class UnionFind {
        private final int[] parents;
        private final int[] size;
        private final int[] walkAndValue;

        UnionFind(int n) {
            parents = new int[n];
            size = new int[n];
            walkAndValue = new int[n];

            for (int i = 0; i < n; ++i) {
                parents[i] = i;
                size[i] = 1;
                walkAndValue[i] = -1;
            }
        }

        public int getParent(int node) {
            if (parents[node] == node) return node;

            return parents[node] = getParent(parents[node]);
        }

        public void computeUnion(int node1, int node2, int wt) {
            int parent1 = getParent(node1);
            int parent2 = getParent(node2);

            if (parent1 == parent2) {
                if (walkAndValue[parent1] == -1) {
                    walkAndValue[parent1] = wt & walkAndValue[parent2];
                }
                else {
                    walkAndValue[parent1] &= (wt & walkAndValue[parent2]);
                }
            }

            if (size[parent2] > size[parent1]) {
                int temp = parent1;
                parent1 = parent2;
                parent2 = temp;
            }

            parents[parent2] = parent1;
            size[parent1] += size[parent2];

            if (walkAndValue[parent1] == -1) {
                walkAndValue[parent1] = wt & walkAndValue[parent2];
            }
            else {
                walkAndValue[parent1] &= (wt & walkAndValue[parent2]);
            }
        }

        public int getWalkAndValue(int node) {
            return walkAndValue[node];
        }
    }

    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        UnionFind unionFind = new UnionFind(n);
        int q = query.length;
        int[] answer = new int[q];

        for (int[] edge : edges) {
            unionFind.computeUnion(edge[0], edge[1], edge[2]);
        }

        for (int i = 0; i < q; ++i) {
            int u = query[i][0];
            int v = query[i][1];
            if (u == v) {
                answer[i] = 0;
                continue;
            }
            int parent1 = unionFind.getParent(u);
            int parent2 = unionFind.getParent(v);
            answer[i] = (parent1 == parent2 ? unionFind.getWalkAndValue(parent1) : -1);
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
            int edgeCount = sc.nextInt();
            int[][] edges = new int[edgeCount][3];
            for (int i = 0; i < edgeCount; ++i) {
                edges[i][0] = sc.nextInt();
                edges[i][1] = sc.nextInt();
                edges[i][2] = sc.nextInt();
            }
            int q = sc.nextInt();
            int[][] queries = new int[q][2];
            for (int i = 0; i < q; ++i) {
                queries[i][0] = sc.nextInt();
                queries[i][1] = sc.nextInt();
            }

            Solution solution = new Solution();
            int[] answer = solution.minimumCost(n, edges, queries);
            for (int x : answer) {
                System.out.print(x + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}
