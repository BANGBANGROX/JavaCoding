import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution {
    private List<List<Integer>> tree;
    private int[] values;
    private int k;
    private int answer;

    private int dfs(int node, int parent) {
        int currentSum = 0;

        for (int child : tree.get(node)) {
            if (child != parent) {
                currentSum = (currentSum + dfs(child, node)) % k;
            }
        }

        currentSum = (currentSum + values[node]) % k;

        if (currentSum == 0) {
            ++answer;
        }

        return currentSum;
    }

    public int maxKDivisibleComponents(int n, int[][] edges,
                                       int[] values, int k) {
        tree = new ArrayList<>();
        this.values = values;
        this.k = k;
        answer = 0;

        for (int i = 0; i < n; ++i) {
            tree.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            tree.get(edge[0]).add(edge[1]);
            tree.get(edge[1]).add(edge[0]);
        }

        dfs(0, -1);

        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        while (testCases-- > 0) {
            int n = scanner.nextInt();
            int[][] edges = new int[n - 1][2];
            for (int i = 0; i < n - 1; ++i) {
                edges[i][0] = scanner.nextInt();
                edges[i][1] = scanner.nextInt();
            }
            int[] values = new int[n];
            for (int i = 0; i < n; ++i) {
                values[i] = scanner.nextInt();
            }
            int k = scanner.nextInt();

            System.out.println(new Solution().maxKDivisibleComponents(n, edges, values, k));
        }

        scanner.close();
    }
}
