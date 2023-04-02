//{ Driver Code Starts
// Initial Template for Java

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] edges = new int[m][3];
            for (int i = 0; i < m; i++) {
                edges[i][0] = sc.nextInt();
                edges[i][1] = sc.nextInt();
                edges[i][2] = sc.nextInt();
            }
            Solution obj = new Solution();
            List<Integer> ans = obj.shortestPath(n, edges);
            for (int e : ans) {
                System.out.print(e + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    private int[] distance;
    private int[] previous;
    private final ArrayList<ArrayList<ArrayList<Integer>>> graph = new ArrayList<>();
    private final TreeSet<ArrayList<Integer>> st = new TreeSet<>((a, b) ->
            !Objects.equals(a.get(0), b.get(0)) ? a.get(0) - b.get(0) :
                    a.get(1) - b.get(1));

    private void calculateDistance() {
        distance[1] = 0;
        st.add(new ArrayList<>(Arrays.asList(0, 1)));

        while (!st.isEmpty()) {
            ArrayList<Integer> current = st.pollFirst();
            assert current != null;
            int node = current.get(1);
            int dis = current.get(0);
            for (ArrayList<Integer> childNode : graph.get(node)) {
                int child = childNode.get(0);
                int wt = childNode.get(1);
                if (distance[child] > dis + wt) {
                    st.remove(new ArrayList<>(Arrays.asList(distance[child], child)));
                    distance[child] = wt + dis;
                    previous[child] = node;
                    st.add(new ArrayList<>(Arrays.asList(distance[child], child)));
                }
            }
        }
    }

    public List<Integer> shortestPath(int n, int[][] edges) {
        // code here
        distance = new int[n + 1];
        previous = new int[n + 1];
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i <= n; ++i) {
            distance[i] = Integer.MAX_VALUE;
            previous[i] = -1;
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            graph.get(u).add(new ArrayList<>(Arrays.asList(v, wt)));
            graph.get(v).add(new ArrayList<>(Arrays.asList(u, wt)));
        }

        calculateDistance();

        if (previous[n] == -1) {
            ans.add(-1);
            return ans;
        }

        int i = n;

        while (i != -1) {
            ans.add(i);
            i = previous[i];
        }

        Collections.reverse(ans);

        return ans;
    }
}