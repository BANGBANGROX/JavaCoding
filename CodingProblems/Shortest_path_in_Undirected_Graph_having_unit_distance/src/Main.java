//{ Driver Code Starts

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] edge = new int[m][2];
            for (int i = 0; i < m; i++) {
                edge[i][0] = sc.nextInt();
                edge[i][1] = sc.nextInt();
            }
            int src = sc.nextInt();
            Solution obj = new Solution();
            int[] res = obj.shortestPath(edge, n, src);
            for (int i = 0; i < n; i++) {
                System.out.print(res[i] + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    public int[] shortestPath(int[][] edges, int n, int src) {
        // Code here
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        int[] ans = new int[n];

        for (int i = 0; i < n; ++i) {
            ans[i] = Integer.MAX_VALUE;
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        q.add(src);
        ans[src] = 0;

        while (!q.isEmpty()) {
            int node = q.poll();
            for (int child : graph.get(node)) {
                if (ans[child] > ans[node] + 1) {
                    ans[child] = ans[node] + 1;
                    q.add(child);
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