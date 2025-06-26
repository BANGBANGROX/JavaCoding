import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Solution {
    private List<List<Integer>> tree;
    private int[] cost;
    private int answer;

    public int minIncrease(final int n, final int[][] edges, final int[] cost) {
        tree = new ArrayList<>();
        this.cost = cost;
        answer = 0;

        for (int i = 0; i < n; ++i) {
            tree.add(new ArrayList<>());
        }

        for (final int[] edge : edges) {
            tree.get(edge[0]).add(edge[1]);
            tree.get(edge[1]).add(edge[0]);
        }

        dfs(0, -1);

        return answer;
    }

    private long dfs(final int node, final int parent) {
        long currentCost = cost[node];
        final List<Long> currentList = new ArrayList<>();

        for (final int child : tree.get(node)) {
            if (child != parent) {
                currentList.add(dfs(child, node));
            }
        }

        if (currentList.isEmpty()) {
            return currentCost;
        }

        long maxCost = currentList.stream().max(Comparator.comparingLong(a -> a)).get();

        for (final long val : currentList) {
            if (val != maxCost) {
                ++answer;
            }
        }

        return currentCost + maxCost;
    }
}

public class Main {
   public static void main(String[] args) {
       final Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           final int n = scanner.nextInt();
           final int[][] edges = new int[n - 1][2];
           for (int i = 0; i < n - 1; ++i) {
               edges[i][0] = scanner.nextInt();
               edges[i][1] = scanner.nextInt();
           }
           final int[] cost = new int[n];
           for (int i = 0; i < n; ++i) {
               cost[i] = scanner.nextInt();
           }

           System.out.println(new Solution().minIncrease(n, edges, cost));
       }
       
       scanner.close();
   }
}
