import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeSet;

class Solution {
    private List<List<Integer>> graph;
    private int componentId;
    private Map<Integer, TreeSet<Integer>> componentIdToNodesMap;
    private Map<Integer, Integer> nodeToComponentIdMap;
    private boolean[] visited;

    public int[] processQueries(final int c, final int[][] connections, final int[][] queries) {
        graph = new ArrayList<>();
        componentId = 0;
        componentIdToNodesMap = new HashMap<>();
        nodeToComponentIdMap = new HashMap<>();
        visited = new boolean[c + 1];
        final int q = queries.length;
        final List<Integer> answer = new ArrayList<>();

        for (int i = 0; i <= c; ++i) {
            graph.add(new ArrayList<>());
        }

        for (final int[] connection : connections) {
            graph.get(connection[0]).add(connection[1]);
            graph.get(connection[1]).add(connection[2]);
        }

        for (int i = 1; i <= c; ++i) {
            if (!visited[i]) {
                dfs(i);
                ++componentId;
            }
        }

        for (int[] query : queries) {
            final int currentComponentId = nodeToComponentIdMap.get(query[1]);

            if (query[0] == 1) {
                if (componentIdToNodesMap.get(currentComponentId).contains(query[1])) {
                    answer.add(query[1]);
                } else if (!componentIdToNodesMap.get(currentComponentId).isEmpty()) {
                    answer.add(componentIdToNodesMap.get(currentComponentId).first());
                } else {
                    answer.add(-1);
                }
            } else {
                componentIdToNodesMap.get(currentComponentId).remove(query[1]);
            }
        }

        return answer.stream().mapToInt(k -> k).toArray();
    }

    private void dfs(final int node) {
        visited[node] = true;

        componentIdToNodesMap.computeIfAbsent(componentId, k -> new TreeSet<>()).add(node);
        nodeToComponentIdMap.put(node, componentId);

        for (final int child : graph.get(node)) {
            if (!visited[child]) {
                dfs(child);
            }
        }
    }
}

public class Main {
   public static void main(String[] args) {
       final Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           final int c = scanner.nextInt();
           final int n = scanner.nextInt();
           final int[][] connections = new int[n][2];
           for (int i = 0; i < n; ++i) {
               connections[i][0] = scanner.nextInt();
               connections[i][1] = scanner.nextInt();
           }
           final int q = scanner.nextInt();
           final int[][] queries = new int[q][2];
           for (int i = 0; i < q; ++i) {
               queries[i][0] = scanner.nextInt();
               queries[i][1] = scanner.nextInt();
           }

           for (final int x : new Solution().processQueries(c, connections, queries)) {
               System.out.print(x + " ");
           }
           System.out.println();
       }
       
       scanner.close();
   }
}
