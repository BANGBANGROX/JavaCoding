import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution {
    private List<List<Integer>> graph;
    private int[] timeOfNode;

    private void dfs(int node, int parent, int[] informTime) {
        int maxTime = 0;

        timeOfNode[node] += informTime[node];

        for (int child : graph.get(node)) {
            if (child != parent) {
                dfs(child, node, informTime);
                maxTime = Math.max(maxTime, timeOfNode[child]);
            }
        }

        timeOfNode[node] += maxTime;
    }

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        graph = new ArrayList<>(n);
        timeOfNode = new int[n];

        for (int i = 0; i < n; ++i) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < n; ++i) {
            if (manager[i] == -1) continue;
            graph.get(manager[i]).add(i);
        }

        dfs(headID, -1, informTime);

        return timeOfNode[headID];
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            int headId = sc.nextInt();
            int[] manager = new int[n];
            for (int i = 0; i < n; ++i) {
                manager[i] = sc.nextInt();
            }
            int[] informTime = new int[n];
            for (int i = 0; i < n; ++i) {
                informTime[i] = sc.nextInt();
            }

            Solution solution = new Solution();
            System.out.print(solution.numOfMinutes(n, headId, manager, informTime));
        }

        sc.close();
    }
}
