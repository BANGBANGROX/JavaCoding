import java.util.*;

class Solution {
    private ArrayList<Integer> topologicalSort(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        int[] inDegree = new int[n + 1];

        for (int i = 0; i < n + 1; ++i) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge: edges) {
            graph.get(edge[1]).add(edge[0]);
            ++inDegree[edge[0]];
        }

        for (int i = 1; i <= n; ++i) {
            if (inDegree[i] == 0) q.add(i);
        }

        while (!q.isEmpty()) {
            int node = q.poll();
            ans.add(node);
            for (int child: graph.get(node)) {
                --inDegree[child];
                if (inDegree[child] == 0) q.add(child);
            }
        }

        return ans;
    }

    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        int[][] ans = new int[k][k];
        ArrayList<Integer> top1 = topologicalSort(k, rowConditions);
        ArrayList<Integer> top2 = topologicalSort(k, colConditions);
        HashMap<Integer, Integer> index = new HashMap<>();

        if (top1.size() < k || top2.size() < k) return new int[][]{};

        for (int i = 0; i < k; ++i) {
            index.put(top2.get(i), i);
        }

        for (int i = k - 1; i >= 0; --i) {
            int num = top1.get(k - i - 1);
            int idx = k - 1 - index.get(num);
            ans[i][idx] = num;
        }

        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int k = sc.nextInt();
            int m = sc.nextInt();
            int[][] rowConditions = new int[m][2];
            for (int i = 0; i < m; ++i) {
                rowConditions[i][0] = sc.nextInt();
                rowConditions[i][1] = sc.nextInt();
            }
            int n = sc.nextInt();
            int[][] colConditions = new int[n][2];
            for (int i = 0; i < n; ++i) {
                colConditions[i][0] = sc.nextInt();
                colConditions[i][1] = sc.nextInt();
            }

            Solution solution = new Solution();
            int[][] ans = solution.buildMatrix(k, rowConditions, colConditions);
            for (int[] x: ans) {
                for (int y: x) System.out.print(y + " ");
                System.out.println();
            }
        }

        sc.close();
    }
}
