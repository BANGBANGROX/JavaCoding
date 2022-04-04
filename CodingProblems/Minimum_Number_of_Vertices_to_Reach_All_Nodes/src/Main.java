import java.util.*;

class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
         int[] inDegree = new int[n];
         List<Integer> ans = new ArrayList<>();

         for (List<Integer> edge : edges) {
             int v = edge.get(1);
             ++inDegree[v];
         }

         for (int i = 0; i < n; ++i) {
             if (inDegree[i] == 0) ans.add(i);
         }

         return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            List<List<Integer>> edges = new ArrayList<>(m);
            for (int i = 0; i < m; ++i) {
                edges.add(new ArrayList<>());
            }

            Solution solution = new Solution();
            System.out.println(solution.findSmallestSetOfVertices(n, edges));
        }

        sc.close();
    }
}
