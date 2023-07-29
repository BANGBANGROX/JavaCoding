import java.util.*;

class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        int nodesVisited = 0;
        int answer = 0;
        int[][] colorsCount = new int[n][26];
        int[] inDegree = new int[n];
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < n; ++i) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            ++inDegree[v];
            graph.get(u).add(v);
        }

        for (int i = 0; i < n; ++i) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int node = q.poll();
            ++colorsCount[node][colors.charAt(node) - 'a'];
            answer = Math.max(answer, colorsCount[node][colors.charAt(node) - 'a']);
            ++nodesVisited;
            for (int child : graph.get(node)) {
                for (int color = 0; color < 26; ++color) {
                    colorsCount[child][color] = Math.max(colorsCount[child][color],
                            colorsCount[node][color]);
                }
                --inDegree[child];
                if (inDegree[child] == 0) {
                    q.add(child);
                }
            }
        }

        return nodesVisited < n ? -1 : answer;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            String colors = sc.next();
            int m = sc.nextInt();
            int[][] edges = new int[m][2];
            for (int i = 0; i < m; ++i) {
                edges[i][0] = sc.nextInt();
                edges[i][1] = sc.nextInt();
            }

            Solution solution = new Solution();
            System.out.println(solution.largestPathValue(colors, edges));
        }

        sc.close();
    }
}
