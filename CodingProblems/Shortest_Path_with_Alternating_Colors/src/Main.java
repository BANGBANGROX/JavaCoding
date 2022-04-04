import java.util.*;

class Solution {
    private static class Pair {
        int first;
        int second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    private static class Node {
        int value;
        int previousColor;
        int length;

        Node(int value, int previousColor, int length) {
            this.value = value;
            this.previousColor = previousColor;
            this.length = length;
        }
    }

    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
         List<List<Pair>> graph = new ArrayList<>(n);
         boolean[][] visited = new boolean[n][2];
         int[] ans = new int[n];
         Queue<Node> q = new LinkedList<>();

         for (int i = 0; i < n; ++i) {
             graph.add(new ArrayList<>());
         }

         for (int[] edge : redEdges) {
             int u = edge[0];
             int v = edge[1];
             graph.get(u).add(new Pair(v, 0));
         }

         for (int[] edge : blueEdges) {
             int u = edge[0];
             int v = edge[1];
             graph.get(u).add(new Pair(v, 1));
         }

         Arrays.fill(ans, -1);

         q.add(new Node(0, -1, 0));
         visited[0][1] = visited[0][0] = true;

         while (!q.isEmpty()) {
             int node = q.peek().value;
             int previousColor = q.peek().previousColor;
             int length = q.peek().length;
             q.poll();
             if (ans[node] == -1) ans[node] = length;
             for (Pair childNode : graph.get(node)) {
                 int child = childNode.first;
                 int color = childNode.second;
                 if (color != previousColor && !visited[child][color]) {
                     visited[child][color] = true;
                     q.add(new Node(child, color, length + 1));
                 }
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
            int m = sc.nextInt();
            int[][] redEdges = new int[m][2];
            for (int i = 0; i < m; ++i) {
                redEdges[i][0] = sc.nextInt();
                redEdges[i][1] = sc.nextInt();
            }
            m = sc.nextInt();
            int[][] blueEdges = new int[m][2];
            for (int i = 0; i < m; ++i) {
                blueEdges[i][0] = sc.nextInt();
                blueEdges[i][1] = sc.nextInt();
            }

            Solution solution = new Solution();
            int[] ans = solution.shortestAlternatingPaths(n, redEdges, blueEdges);
            for (int x : ans) System.out.print(x + " ");
            System.out.println();
        }

        sc.close();
    }
}
