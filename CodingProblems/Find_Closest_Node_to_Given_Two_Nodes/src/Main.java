import java.util.*;

class Solution {
    private int[] bfs(int[] edges, int node) {
        int n = edges.length;
        int[] ans = new int[n];
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();

        Arrays.fill(ans, Integer.MAX_VALUE);

        q.add(node);
        visited[node] = true;
        ans[node] = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; ++i) {
                assert q.peek() != null;
                int nextNode = q.poll();
                int child = edges[nextNode];
                if (child == -1 || visited[child]) continue;
                ans[child] = ans[nextNode] + 1;
                visited[child] = true;
                q.add(child);
            }
        }

        return ans;
    }

    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int[] dis1 = bfs(edges, node1);
        int[] dis2 = bfs(edges, node2);
        int ans = -1;
        int minDistance = Integer.MAX_VALUE;
        int n = edges.length;

        for (int i = 0; i < n; ++i) {
            int distance = Math.max(dis1[i], dis2[i]);
            if (distance < minDistance) {
                ans = i;
                minDistance = distance;
            }
        }

        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            int[] edges = new int[n];
            for (int i = 0; i < n; ++i) {
                edges[i] = sc.nextInt();
            }
            int node1 = sc.nextInt();
            int node2 = sc.nextInt();

            Solution solution = new Solution();
            System.out.println(solution.closestMeetingNode(edges, node1, node2));
        }

        sc.close();
    }
}
