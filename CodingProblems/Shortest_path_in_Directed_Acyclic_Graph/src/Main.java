//{ Driver Code Starts

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] edge = new int[m][3];
            for (int i = 0; i < m; i++) {
                edge[i][0] = sc.nextInt();
                edge[i][1] = sc.nextInt();
                edge[i][2] = sc.nextInt();
            }
            Solution obj = new Solution();
            int[] res = obj.shortestPath(n, edge);
            for (int i = 0; i < n; i++) {
                System.out.print(res[i] + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    public int[] shortestPath(int n, int[][] edges) {
        //Code here
        ArrayList<ArrayList<ArrayList<Integer>>> graph = new ArrayList<>();
        TreeSet<ArrayList<Integer>> ts = new TreeSet<>(Comparator.comparingInt(a -> a.get(0)));
        int[] ans = new int[n];

        for (int i = 0; i < n; ++i) {
            graph.add(new ArrayList<>());
            ans[i] = Integer.MAX_VALUE;
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(new ArrayList<>(Arrays.asList(edge[1], edge[2])));
        }

        ts.add(new ArrayList<>(Arrays.asList(0, 0)));
        ans[0] = 0;

        while (!ts.isEmpty()) {
            ArrayList<Integer> currentNode = ts.pollFirst();
            assert currentNode != null;
            int node = currentNode.get(1);
            for (ArrayList<Integer> childNode : graph.get(node)) {
                int child = childNode.get(0);
                int wt = childNode.get(1);
                if (ans[child] > ans[node] + wt) {
                    ArrayList<Integer> next = new ArrayList<>(Arrays.asList(ans[child], child));
                    ts.remove(next);
                    ans[child] = ans[node] + wt;
                    next.set(0, ans[child]);
                    ts.add(next);
                }
            }
        }

        for (int i = 0; i < n; ++i) {
            if (ans[i] == Integer.MAX_VALUE) {
                ans[i] = -1;
            }
        }

        return ans;
    }
}