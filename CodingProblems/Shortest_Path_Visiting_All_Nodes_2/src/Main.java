import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Solution {
    private static class Pair {
       int first;
       int second;

       Pair(int first, int second) {
           this.first = first;
           this.second = second;
       }
    }

    public int shortestPathLength(int[][] graph) {
         int n = graph.length;
         int fullMask = (1 << n) - 1;
         int length = 0;
         boolean[][] visited = new boolean[n][fullMask + 1];
         Queue<Pair> q = new LinkedList<>();

         for (int i = 0; i < n; ++i) {
             q.add(new Pair(i, 1 << i));
             visited[i][1 << i] = true;
         }

         while (!q.isEmpty()) {
             int size = q.size();
             for (int i = 0; i < size; ++i) {
                 assert q.peek() != null;
                 int node = q.peek().first;
                 int mask = q.peek().second;
                 q.poll();
                 for (int child : graph[node]) {
                     int newMask = mask | (1 << child);
                     if (newMask == fullMask) return length + 1;
                     if (!visited[child][newMask]) {
                         q.add(new Pair(child, newMask));
                         visited[child][newMask] = true;
                     }
                 }
             }
             ++length;
         }

         return 0;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            int[][] graph = new int[n][];
            for (int i = 0; i < n; ++i) {
                int m = sc.nextInt();
                graph[i] = new int[m];
                for (int j = 0; j < m; ++j) {
                    graph[i][j] = sc.nextInt();
                }
            }

            Solution solution = new Solution();
            System.out.println(solution.shortestPathLength(graph));
        }

        sc.close();
    }
}
