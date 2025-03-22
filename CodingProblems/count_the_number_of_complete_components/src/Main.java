import javax.annotation.processing.SupportedSourceVersion;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

class Solution {
    private Set<String> visitedEdges;
    private Set<Integer> visitedNodes;
    private List<List<Integer>> graph;
    private int nodeCnt;

    private void edgeDfs(int node) {
        if (visitedNodes.add(node)) {
            ++nodeCnt;
        }

        for (int child : graph.get(node)) {
            String forwardEdge = node + "|" + child;
            String backwardEdge = child + "|" + node;
            if (!visitedEdges.contains(forwardEdge) && !visitedEdges.contains(backwardEdge)) {
                visitedEdges.add(forwardEdge);
                visitedEdges.add(backwardEdge);
                edgeDfs(child);
            }
        }
    }

    public int countCompleteComponents(int n, int[][] edges) {
        graph = new ArrayList<>();
        visitedNodes = new HashSet<>();
        int answer = 0;

        for (int i = 0; i < n; ++i) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        for (int i = 0; i < n; ++i) {
            if (!visitedNodes.contains(i)) {
                visitedEdges = new HashSet<>();
                nodeCnt = 0;
                edgeDfs(i);
                if (nodeCnt * (nodeCnt - 1) == visitedEdges.size()) {
                    ++answer;
                }
            }
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
           int[][] edges = new int[n][2];
           for (int i = 0; i < n; ++i) {
               edges[i][0] = scanner.nextInt();
               edges[i][1] = scanner.nextInt();
           }

           System.out.println(new Solution().countCompleteComponents(n, edges));
       }
       
       scanner.close();
   }
}
