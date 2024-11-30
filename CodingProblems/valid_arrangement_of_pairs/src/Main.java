import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Solution {
    private Map<Integer, Deque<Integer>> graph;
    private List<Integer> nodesInPath;

    private void dfs(int node) {
        Deque<Integer> neighbours = graph.get(node);

        while (neighbours != null && !neighbours.isEmpty()) {
            int child = neighbours.pollFirst();
            dfs(child);
        }

        nodesInPath.add(node);
    }

    public int[][] validArrangement(int[][] pairs) {
        graph = new HashMap<>();
        nodesInPath = new ArrayList<>();
        Map<Integer, Integer> inDegree = new HashMap<>();
        Map<Integer, Integer> outDegree = new HashMap<>();
        int startNode = -1;

        for (int[] pair : pairs) {
            int u = pair[0];
            int v = pair[1];
            inDegree.put(v, inDegree.getOrDefault(v, 0) + 1);
            outDegree.put(u, outDegree.getOrDefault(u, 0) + 1);
            graph.computeIfAbsent(u, k -> new LinkedList<>()).add(v);
        }

        for (Map.Entry<Integer, Integer> entry : outDegree.entrySet()) {
            int node = entry.getKey();
            if (entry.getValue() == inDegree.getOrDefault(node, 0) + 1) {
                startNode = node;
                break;
            }
        }

        if (startNode == -1) {
            startNode = pairs[0][0];
        }

        dfs(startNode);

        Collections.reverse(nodesInPath);

        int[][] answer = new int[nodesInPath.size() - 1][2];

        for (int i = 1; i < nodesInPath.size(); ++i) {
            answer[i - 1][0] = nodesInPath.get(i - 1);
            answer[i - 1][1] = nodesInPath.get(i);
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
           int[][] pairs = new int[n][2];
           for (int i = 0; i < n; ++i) {
               pairs[i][0] = scanner.nextInt();
               pairs[i][1] = scanner.nextInt();
           }

           int[][] answer = new Solution().validArrangement(pairs);
           for (int[] pair : answer) {
               System.out.println(pair[0] + " " + pair[1]);
           }
           System.out.println();
       }
       
       scanner.close();
   }
}
