import java.util.*;

class Solution {
    private List<List<Integer>> graph;
    private boolean[] visited;

    private void dfs(int node) {
        visited[node] = true;

        for (int child : graph.get(node)) {
            if (!visited[child]) dfs(child);
        }
    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        graph = rooms;
        visited = new boolean[n];

        dfs(0);

        for (int i = 0; i < n; ++i) {
            if (!visited[i]) return false;
        }

        return true;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            List<List<Integer>> rooms = new ArrayList<>();
            for (int i = 0; i < n; ++i) {
                int m = sc.nextInt();
                List<Integer> keys = new ArrayList<>();
                for (int j = 0; j < m; ++j) {
                    int key = sc.nextInt();
                    keys.add(key);
                }
                rooms.add(new ArrayList<>(keys));
            }

            Solution solution = new Solution();
            System.out.print(solution.canVisitAllRooms(rooms));
        }

        sc.close();
    }
}
