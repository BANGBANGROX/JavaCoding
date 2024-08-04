import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Solution {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        int q = queries.length;
        int[] answer = new int[q];
        Map<Integer, Integer> edges = new HashMap<>();
        
        for (int i = 0; i < n - 1; ++i) {
            edges.put(i, i + 1);
        }

        for (int i = 0; i < q; ++i) {
            int u = queries[i][0];
            int v = queries[i][1];
            if (!edges.containsKey(u) || edges.get(u) >= v) {
                answer[i] = edges.size();
                continue;
            }
            Integer currentNode = edges.get(u);
            while (currentNode != null && currentNode < v) {
                currentNode = edges.remove(currentNode);
            }
            edges.put(u, v);
            answer[i] = edges.size();
        }

        return answer;
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        while (testCases-- > 0) {
            int n = scanner.nextInt();
            int q = scanner.nextInt();
            int[][] edges = new int[q][2];
            for (int i = 0; i < q; ++i) {
                edges[i][0] = scanner.nextInt();
                edges[i][1] = scanner.nextInt();
            }

            int[] answer = new Solution().shortestDistanceAfterQueries(n, edges);
            for (int x : answer) {
                System.out.print(x + " ");
            }
            System.out.println();
        }

        scanner.close();
    }
}
