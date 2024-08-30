import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

class Solution {
    private int[][] edges;
    private int[][] distances;
    private int source;
    private List<List<List<Integer>>> graph;

    private void computeDistances(int difference, int run) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] != b[1] ? a[1] - b[1] : a[0] - b[0]);

        pq.add(new int[]{source, 0});
        distances[source][run] = 0;

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int currentNode = current[0];
            int currentDistance = current[1];
            if (currentDistance > distances[currentNode][run]) {
                continue;
            }
            for (List<Integer> child : graph.get(currentNode)) {
                int nextNode = child.get(0);
                int edgeIndex = child.get(1);
                int weight = edges[edgeIndex][2];
                if (weight == -1) {
                    weight = 1;
                }
                if (run == 1 && edges[edgeIndex][2] == -1) {
                    int newWeight = difference + distances[nextNode][0] -
                            distances[currentNode][1];
                    if (newWeight > weight) {
                        edges[edgeIndex][2] = weight = newWeight;
                    }
                }
                if (distances[nextNode][run] > distances[currentNode][run] + weight) {
                    distances[nextNode][run] = distances[currentNode][run] + weight;
                    pq.add(new int[]{nextNode, distances[nextNode][run]});
                }
            }
        }
    }

    public int[][] modifiedGraphEdges(int n, int[][] edges, int source, int destination, int
            target) {
        this.edges = edges;
        this.source = source;
        distances = new int[n][2];
        graph = new ArrayList<>();

        for (int i = 0; i < n; ++i) {
            graph.add(new ArrayList<>());
            distances[i][0] = distances[i][1] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < edges.length; ++i) {
            graph.get(edges[i][0]).add(List.of(edges[i][1], i));
            graph.get(edges[i][1]).add(List.of(edges[i][0], i));
        }

        computeDistances(0, 0);

        int difference = target - distances[destination][0];

        if (difference < 0) {
            return new int[][]{};
        }

        computeDistances(difference, 1);

        if (distances[destination][1] < target) {
            return new int[][]{};
        }

        for (int[] edge : edges) {
            if (edge[2] == -1) {
                edge[2] = 1;
            }
        }

        return edges;
    }
}

public class Main {
   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           int n = scanner.nextInt();
           int m = scanner.nextInt();
           int[][] edges = new int[m][3];
           for (int i = 0; i < m; ++i) {
               edges[i][0] = scanner.nextInt();
               edges[i][1] = scanner.nextInt();
               edges[i][2] = scanner.nextInt();
           }
           int source = scanner.nextInt();
           int destination = scanner.nextInt();
           int target = scanner.nextInt();

           int[][] answer = new Solution().modifiedGraphEdges(n, edges, source, destination, target);
           for (int[] edge : answer) {
               System.out.println(edge[0] + " " + edge[1] + " " + edge[2]);
           }
           System.out.println();
       }
       
       scanner.close();
   }
}
