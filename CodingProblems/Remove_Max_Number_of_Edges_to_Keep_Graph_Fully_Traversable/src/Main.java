import java.util.Scanner;

class Solution {
    private static class UnionFind {
        private final int[] parent;
        private final int[] componentSize;
        private int componentsCount;

        UnionFind(int size) {
            componentsCount = size;
            parent = new int[size];
            componentSize = new int[size];

            for (int i = 0; i < size; ++i) {
                parent[i] = i;
                componentSize[i] = 1;
            }
        }

        private int findParent(int node) {
            if (parent[node] == node) return node;

            return parent[node] = findParent(parent[node]);
        }

        public int performUnion(int node1, int node2) {
            int parentOfNode1 = findParent(node1);
            int parentOfNode2 = findParent(node2);

            if (parentOfNode1 == parentOfNode2) return 0;

            if (componentSize[parentOfNode1] > componentSize[parentOfNode2]) {
                componentSize[parentOfNode1] += componentSize[parentOfNode2];
                parent[parentOfNode2] = parentOfNode1;
            }
            else if (componentSize[parentOfNode1] < componentSize[parentOfNode2]) {
                componentSize[parentOfNode2] += componentSize[parentOfNode1];
                parent[parentOfNode1] = parentOfNode2;
            }
            else {
                componentSize[parentOfNode1] += componentSize[parentOfNode2];
                parent[parentOfNode2] = parentOfNode1;
            }

            --componentsCount;

            return 1;
        }

        public boolean isConnected() {
            return componentsCount == 1;
        }
    }

    public int maxNumEdgesToRemove(int n, int[][] edges) {
        UnionFind aliceUnionFind = new UnionFind(n);
        UnionFind bobUnionFind = new UnionFind(n);
        int edgesNeeded = 0;
        int totalEdges = edges.length;

        for (int[] edge : edges) {
            int type = edge[0];
            int u = edge[1] - 1;
            int v = edge[2] - 1;
            if (type == 3) {
                edgesNeeded += (aliceUnionFind.performUnion(u, v) |
                        bobUnionFind.performUnion(u, v));
            }
        }

        for (int[] edge : edges) {
            int type = edge[0];
            int u = edge[1] - 1;
            int v = edge[2] - 1;
            if (type == 1) {
                edgesNeeded += aliceUnionFind.performUnion(u, v);
            }
            else if (type == 2) {
                edgesNeeded += bobUnionFind.performUnion(u, v);
            }
        }

        if (aliceUnionFind.isConnected() && bobUnionFind.isConnected())
            return totalEdges - edgesNeeded;

        return -1;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            int edgesCount = sc.nextInt();
            int[][] edges = new int[edgesCount][3];
            for (int i = 0; i < edgesCount; ++i) {
                edges[i][0] = sc.nextInt();
                edges[i][1] = sc.nextInt();
                edges[i][2] = sc.nextInt();
            }

            Solution solution = new Solution();
            System.out.println(solution.maxNumEdgesToRemove(n, edges));
        }

        sc.close();
    }
}
