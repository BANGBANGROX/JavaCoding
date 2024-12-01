import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Solution {
    private int cnt;
    private int threshold;
    private Map<Integer, List<Integer>> tree;

    private void dfs(int node, int currentLevel, int parent) {
        if (currentLevel <= threshold) ++cnt;

        for (int child : tree.getOrDefault(node, new ArrayList<>())) {
            if (child != parent) {
                dfs(child, currentLevel + 1, node);
            }
        }
    }

    private int buildTreeAndGetMaxNode(int[][] edges,
                                       Map<Integer, List<Integer>> tree) {
        int maxNode = 0;

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            maxNode = Math.max(maxNode, Math.max(u, v));
            tree.computeIfAbsent(u, x -> new ArrayList<>()).add(v);
            tree.computeIfAbsent(v, x -> new ArrayList<>()).add(u);
        }

        return maxNode;
    }

    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        Map<Integer, List<Integer>> tree1 = new HashMap<>();
        Map<Integer, List<Integer>> tree2 = new HashMap<>();
        int nodesInTree1 = buildTreeAndGetMaxNode(edges1, tree1);
        int nodesInTree2 = buildTreeAndGetMaxNode(edges2, tree2);
        int maxValueInGraph2 = 0;
        int[] answer = new int[nodesInTree1 + 1];

        this.tree = tree2;
        this.threshold = k - 1;

        for (int i = 0; i <= nodesInTree2; ++i) {
            cnt = 0;
            dfs(i, 0, -1);
            maxValueInGraph2 = Math.max(maxValueInGraph2, cnt);
        }

        this.tree = tree1;
        this.threshold = k;

        for (int i = 0; i <= nodesInTree1; ++i) {
            cnt = 0;
            dfs(i, 0, -1);
            answer[i] = cnt + maxValueInGraph2;
        }

        return answer;
    }
}

public class Main {
   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           int m = scanner.nextInt();
           int[][] edges1 = new int[m][2];
           for (int i = 0; i < m; ++i) {
               edges1[i][0] = scanner.nextInt();
               edges1[i][1] = scanner.nextInt();
           }
           int n = scanner.nextInt();
           int[][] edges2 = new int[n][2];
           for (int i = 0; i < n; ++i) {
               edges2[i][0] = scanner.nextInt();
               edges2[i][1] = scanner.nextInt();
           }
           int k = scanner.nextInt();

           int[] answer = new Solution().maxTargetNodes(edges1, edges2, k);
           for (int x : answer) {
               System.out.print(x + " ");
           }
           System.out.println();
       }
       
       scanner.close();
   }
}
