import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

class Solution {
    private List<List<List<Integer>>> graph;
    private int n;

    private int countNumberOfShortestPaths(int source, int destination) {
        long[] distance = new long[n];
        long[] pathCount = new long[n];
        PriorityQueue<List<Long>> pq = new PriorityQueue<>((a, b) -> (int) (a.get(1) - b.get(1)));
        final int MOD = (int) 1e9 + 7;

        Arrays.fill(distance, Long.MAX_VALUE);

        distance[source] = 0;
        pathCount[source] = 1;
        pq.add(List.of((long) source, distance[source]));

        while (!pq.isEmpty()) {
            List<Long> top = pq.poll();
            int node = Math.toIntExact(top.getFirst());
            long currentDistance = top.get(1);
            for (List<Integer> child : graph.get(node)) {
                int childNode = child.getFirst();
                int wt = child.get(1);
                if (wt + currentDistance < distance[childNode]) {
                    pq.remove(List.of((long) childNode, distance[childNode]));
                    distance[childNode] = wt + distance[node];
                    pq.add(List.of((long) childNode, distance[childNode]));
                    pathCount[childNode] = pathCount[node];
                } else if (wt + currentDistance == distance[childNode]) {
                    pathCount[childNode] = (pathCount[childNode] + pathCount[node]) % MOD;
                }
            }
        }

        return (int) pathCount[destination];
    }


    public int countPaths(int n, int[][] roads) {
        this.n = n;
        graph = new ArrayList<>();

        for (int i = 0; i < n; ++i) {
            graph.add(new ArrayList<>());
        }

        for (int[] road : roads) {
            graph.get(road[0]).add(List.of(road[1], road[2]));
            graph.get(road[1]).add(List.of(road[0], road[2]));
        }

        return countNumberOfShortestPaths(0, n - 1);
    }
}

public class Main {
   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           int n = scanner.nextInt();
           int edgesCnt = scanner.nextInt();
           int[][] edges = new int[edgesCnt][3];
           for (int i = 0; i < edgesCnt; ++i) {
               edges[i] = new int[]{scanner.nextInt(), scanner.nextInt(), scanner.nextInt()};
           }

           System.out.println(new Solution().countPaths(n, edges));
       }
       
       scanner.close();
   }
}
