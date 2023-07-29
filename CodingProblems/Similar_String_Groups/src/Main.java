import java.util.ArrayList;
import java.util.Scanner;

class Solution {
    private ArrayList<ArrayList<Integer>> graph;
    private boolean[] visited;

    private boolean isSimilar(String s1, String s2) {
        int n = s1.length();
        int differingCharacters = 0;

        for (int i = 0; i < n; ++i) {
            if (s1.charAt(i) != s2.charAt(i)) {
                ++differingCharacters;
            }
        }

        return differingCharacters == 0 || differingCharacters == 2;
    }

    private void dfs(int node) {
        visited[node] = true;

        for (int child : graph.get(node)) {
            if (!visited[child]) {
                dfs(child);
            }
        }
    }

    public int numSimilarGroups(String[] strs) {
        int n = strs.length;
        int answer = 0;
        graph = new ArrayList<>();
        visited = new boolean[n];

        for (int i = 0; i < n; ++i) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (isSimilar(strs[i], strs[j])) {
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                }
            }
        }

        for (int i = 0; i < n; ++i) {
            if (!visited[i]) {
                dfs(i);
                ++answer;
            }
        }

        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            String[] strs = new String[n];
            for (int i = 0; i < n; ++i) {
                strs[i] = sc.next();
            }

            Solution solution = new Solution();
            System.out.println(solution.numSimilarGroups(strs));
        }

        sc.close();
    }
}
