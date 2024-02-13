import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

class Solution {
    private HashMap<Integer, ArrayList<Integer>> graph;
    private ArrayList<Integer> answer;
    private HashSet<Integer> visited;

    private void dfs(int node) {
        visited.add(node);

        for (int child : graph.getOrDefault(node, new ArrayList<>())) {
            if (!visited.contains(child)) {
                dfs(child);
            }
        }

        answer.add(node);
    }

    public int[] restoreArray(int[][] adjacentPairs) {
        graph = new HashMap<>();
        visited = new HashSet<>();
        answer = new ArrayList<>();

        for (int[] pair : adjacentPairs) {
            graph.computeIfAbsent(pair[0], k -> new ArrayList<>()).add(pair[1]);
            graph.computeIfAbsent(pair[1], k -> new ArrayList<>()).add(pair[0]);
        }

        int terminalNode = -1;

        for (int node : graph.keySet()) {
            if (graph.get(node).size() == 1) {
                terminalNode = node;
                break;
            }
        }

        dfs(terminalNode);

        return answer.stream().mapToInt(k -> k).toArray();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            assert n > 1;
            int[][] adjacentPairs = new int[n - 1][2];

            for (int i = 1; i < n; ++i) {
                adjacentPairs[i - 1][0] = sc.nextInt();
                adjacentPairs[i - 1][1] = sc.nextInt();
            }

            Solution solution = new Solution();
            int[] answer = solution.restoreArray(adjacentPairs);
            for (int x : answer) {
                System.out.print(x + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}
