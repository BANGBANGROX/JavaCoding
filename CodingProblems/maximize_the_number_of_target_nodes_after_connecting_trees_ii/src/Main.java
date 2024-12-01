import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class Solution {
    private List<List<Integer>> tree;
    private int[] answer;
    private int[] count;

    private void dfs(int node, int parent, int level) {
        ++count[level % 2];

        for (int child : tree.get(node)) {
            if (child != parent) {
                dfs(child, node, level + 1);
            }
        }
    }

    private void populateAnswer(int node, int parent, int level) {
        answer[node] += count[level % 2];

        for (int child : tree.get(node)) {
            if (child != parent) {
                populateAnswer(child, node, level + 1);
            }
        }
    }

    public int[] maxTargetNodes(int[][] edges1, int[][] edges2) {
        int m = edges1.length + 1;
        int n = edges2.length + 1;
        answer = new int[m];
        List<List<Integer>> tree1 = new ArrayList<>();
        List<List<Integer>> tree2 = new ArrayList<>();

        for (int i = 0; i < m; ++i) {
            tree1.add(new ArrayList<>());
        }

        for (int i = 0; i < n; ++i) {
            tree2.add(new ArrayList<>());
        }

        for (int[] edge : edges1) {
            tree1.get(edge[0]).add(edge[1]);
            tree1.get(edge[1]).add(edge[0]);
        }

        for (int[] edge : edges2) {
            tree2.get(edge[0]).add(edge[1]);
            tree2.get(edge[1]).add(edge[0]);
        }

        tree = tree2;
        count = new int[2];

        for (int i = 0; i < n; ++i) {
            if (tree2.get(i).size() == 1) {
                dfs(i, -1, 0);
                break;
            }
        }

        Arrays.fill(answer, Math.max(count[0], count[1]));
        count = new int[2];
        tree = tree1;

        for (int i = 0; i < m; ++i) {
            if (tree1.get(i).size() == 1) {
                dfs(i, -1, 0);
                populateAnswer(i, -1, 0);
                break;
            }
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

           int[] answer = new Solution().maxTargetNodes(edges1, edges2);
           for (int x : answer) {
               System.out.print(x + " ");
           }
           System.out.println();
       }
       
       scanner.close();
   }
}
