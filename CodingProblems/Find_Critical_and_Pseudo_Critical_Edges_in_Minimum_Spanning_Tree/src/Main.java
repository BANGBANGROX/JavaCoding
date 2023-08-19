import java.util.*;

class Solution {
    private static class UnionFind {
        private final int[] parent;
        private final int[] size;
        private int maxSize;

        UnionFind(int n) {
            parent = new int[n];
            size = new int[n];
            maxSize = 1;

            for (int i = 0; i < n; ++i) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        private int getParent(int node) {
            if (parent[node] == node) {
                return node;
            }

            return parent[node] = getParent(parent[node]);
        }

        public boolean computeUnion(int x, int y) {
            int rootX = getParent(x);
            int rootY = getParent(y);

            if (rootX == rootY) {
                return false;
            }

            if (size[rootX] < size[rootY]) {
                int temp = rootX;
                rootX = rootY;
                rootY = temp;
            }

            size[rootX] += size[rootY];
            parent[rootY] = rootX;
            maxSize = Math.max(maxSize, size[rootX]);

            return true;
        }

        public int getMaxSize() {
            return maxSize;
        }
    }

    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        int m = edges.length;
        int[][] sortedEdges = new int[m][4];
        int stdWt = 0;
        List<List<Integer>> answer = new ArrayList<>();
        UnionFind uf = new UnionFind(n);

        for (int i = 0; i < 2; ++i) {
            answer.add(new ArrayList<>());
        }

        for (int i = 0; i < m; ++i) {
            System.arraycopy(edges[i], 0, sortedEdges[i], 0, 3);
            sortedEdges[i][3] = i;
        }

        Arrays.sort(sortedEdges, Comparator.comparingInt(a -> a[2]));

        for (int i = 0; i < m; ++i) {
            if (uf.computeUnion(sortedEdges[i][0], sortedEdges[i][1])) {
                stdWt += sortedEdges[i][2];
            }
        }

        for (int i = 0; i < m; ++i) {
            UnionFind ufIgnore = new UnionFind(n);
            int ignoreWt = 0;
            for (int j = 0; j < m; ++j) {
                if (i != j && ufIgnore.computeUnion(sortedEdges[j][0], sortedEdges[j][1])) {
                    ignoreWt += sortedEdges[j][2];
                }
            }
            if (ufIgnore.getMaxSize() < n || ignoreWt > stdWt) {
                answer.get(0).add(sortedEdges[i][3]);
            }
            else {
                UnionFind ufTake = new UnionFind(n);
                int takeWt = sortedEdges[i][2];
                ufTake.computeUnion(sortedEdges[i][0], sortedEdges[i][1]);
                for (int j = 0; j < m; ++j) {
                    if (i != j && ufTake.computeUnion(sortedEdges[j][0], sortedEdges[j][1])) {
                        takeWt += sortedEdges[j][2];
                    }
                }
                if (takeWt == stdWt) {
                    answer.get(1).add(sortedEdges[i][3]);
                }
            }
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
            int m = sc.nextInt();
            int[][] edges = new int[m][3];
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < 3; ++j) {
                    edges[i][j] = sc.nextInt();
                }
            }

            Solution solution = new Solution();
            System.out.println(solution.findCriticalAndPseudoCriticalEdges(n, edges));
        }

        sc.close();
    }
}
