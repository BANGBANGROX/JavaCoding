import java.util.*;

class Solution {
    public boolean isPossible(int n, List<List<Integer>> edges) {
        ArrayList<HashSet<Integer>> graph = new ArrayList<>();
        ArrayList<Integer> oddDegreeNodes = new ArrayList<>();

        for (int i = 0; i <= n; ++i) {
            graph.add(new HashSet<>());
        }

        for (List<Integer> edge : edges) {
            int u = edge.get(0);
            int v = edge.get(1);
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        for (int i = 1; i <= n; ++i) {
            if ((graph.get(i).size() & 1) > 0) {
                oddDegreeNodes.add(i);
            }
        }

        if (oddDegreeNodes.size() > 4) return false;

        if (oddDegreeNodes.isEmpty()) return true;

        if (oddDegreeNodes.size() == 4) {
            int a = oddDegreeNodes.get(0);
            int b = oddDegreeNodes.get(1);
            int c = oddDegreeNodes.get(2);
            int d = oddDegreeNodes.get(3);

            return (!graph.get(a).contains(b) && !graph.get(c).contains(d)) ||
                    (!graph.get(a).contains(c) && !graph.get(b).contains(d)) ||
                    (!graph.get(a).contains(d) && !graph.get(b).contains(c));
        }

        // size = 2
        int u = oddDegreeNodes.get(0);
        int v = oddDegreeNodes.get(1);

        if (!graph.get(u).contains(v)) return true;

        for (int i = 1; i <= n; ++i) {
            if (!graph.get(u).contains(i) && !graph.get(v).contains(i)) return true;
        }

        return false;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            List<List<Integer>> edges = new ArrayList<>();
            for (int i = 0; i < m; ++i) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                edges.add(new ArrayList<>(Arrays.asList(u, v)));
            }

            Solution solution = new Solution();
            System.out.println(solution.isPossible(n, edges));
        }

        sc.close();
    }
}
