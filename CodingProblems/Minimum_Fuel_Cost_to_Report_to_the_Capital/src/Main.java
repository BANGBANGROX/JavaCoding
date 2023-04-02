import java.util.ArrayList;
import java.util.Scanner;

class Solution {
    private final ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
    private int seats;
    private long ans;

    private long dfs(int node, int parent) {
        int representatives = 1;

        if (tree.get(node).isEmpty() ||
                (tree.get(node).size() == 1 && tree.get(node).get(0) == parent)) {
            return representatives;
        }

        for (int child : tree.get(node)) {
            if (child != parent) {
                representatives += dfs(child, node);
            }
        }

        if (node > 0) {
            ans += Math.ceil((double) representatives / seats);
        }

        return representatives;
    }

    public long minimumFuelCost(int[][] roads, int seats) {
        int m = roads.length;
        this.seats = seats;
        ans = 0;

        for (int i = 0; i <= m; ++i) {
            tree.add(new ArrayList<>());
        }

        for (int[] road : roads) {
            int u = road[0];
            int v = road[1];
            tree.get(u).add(v);
            tree.get(v).add(u);
        }

        dfs(0, -1);

        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            int[][] roads = new int[n - 1][2];
            for (int i = 0; i < n - 1; ++i) {
                roads[i][0] = sc.nextInt();
                roads[i][1] = sc.nextInt();
            }
            int seats = sc.nextInt();

            Solution solution = new Solution();
            System.out.println(solution.minimumFuelCost(roads, seats));
        }

        sc.close();
    }
}
