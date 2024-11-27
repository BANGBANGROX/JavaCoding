import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

class Solution {
    private List<List<Integer>> graph;
    private int n;

    private int getShortestDistance() {
        Queue<Integer> queue = new LinkedList<>();
        int[] distance = new int[n];

        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[0] = 0;
        queue.add(0);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int child : graph.get(node)) {
                if (distance[child] > distance[node] + 1) {
                    queue.add(child);
                    distance[child] = distance[node] + 1;
                }
            }
        }

        return distance[n - 1];
    }

    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        graph = new ArrayList<>();
        this.n = n;
        int q = queries.length;
        int[] answer = new int[q];

        for (int i = 0; i < n; ++i) {
            graph.add(new ArrayList<>());
            if (i + 1 < n) {
                graph.get(i).add(i + 1);
            }
        }

        for (int i = 0; i < q; ++i) {
            int[] query = queries[i];
            graph.get(query[0]).add(query[1]);
            answer[i] = getShortestDistance();
        }

        return answer;
    }
}

public class Main {
   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           int n = scanner.nextInt();
           int q = scanner.nextInt();
           int[][] queries = new int[q][2];
           for (int i = 0; i < q; ++i) {
               queries[i][0] = scanner.nextInt();
               queries[i][1] = scanner.nextInt();
           }

           int[] answer = new Solution().shortestDistanceAfterQueries(n, queries);
           for (int x : answer) {
               System.out.print(x + " ");
           }
           System.out.println();
       }
       
       scanner.close();
   }
}
