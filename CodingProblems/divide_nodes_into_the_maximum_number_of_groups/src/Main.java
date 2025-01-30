import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

class Solution {
    private List<List<Integer>> graph;
    private int[] value;
    private int n;
    private List<Integer> currentNodes;
    private Set<Integer> visitedNodes;

    private boolean bfs(int startNode, int startValue) {
        value = new int[n + 1];
        currentNodes = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        boolean result = true;

        q.add(startNode);
        value[startNode] = startValue;

        while (!q.isEmpty()) {
            int node = q.poll();
            currentNodes.add(node);
            visitedNodes.add(node);
            for (int child : graph.get(node)) {
                if (value[child] == 0) {
                    value[child] = value[node] + 1;
                    q.add(child);
                } else if (Math.abs(value[child] - value[node]) != 1) {
                    result = false;
                }
            }
        }

        return result;
    }

    public int magnificentSets(int n, int[][] edges) {
        value = new int[n + 1];
        graph = new ArrayList<>();
        visitedNodes = new HashSet<>();
        this.n = n;
        int answer = 0;
        int startValue = 1;

        for (int i = 0; i <= n; ++i) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        for (int i = 1; i <= n; ++i) {
            if (!visitedNodes.contains(i)) {
                boolean anyPass = false;
                if (bfs(i, startValue)) {
                    anyPass = true;
                    answer = Math.max(answer, Arrays.stream(value).max().getAsInt());
                }
                for (int node : currentNodes) {
                    if (node != i && bfs(node, startValue)) {
                        anyPass = true;
                        answer = Math.max(answer, Arrays.stream(value).max().getAsInt());
                    }
                }
                if (anyPass) {
                    startValue = answer + 1;
                } else return -1;
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
           int m = scanner.nextInt();
           int[][] edges = new int[m][2];
           for (int i = 0; i < m; ++i) {
               edges[i][0] = scanner.nextInt();
               edges[i][1] = scanner.nextInt();
           }

           System.out.println(new Solution().magnificentSets(n, edges));
       }
       
       scanner.close();
   }
}
