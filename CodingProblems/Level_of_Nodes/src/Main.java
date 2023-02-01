//{ Driver Code Starts

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V + 1; i++)
                list.add(i, new ArrayList<>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
                list.get(v).add(u);
            }
            int X = sc.nextInt();

            Solution ob = new Solution();

            System.out.println(ob.nodeLevel(V, list, X));
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/

class Solution {
    //Function to find the level of node X.
    public int nodeLevel(int n, ArrayList<ArrayList<Integer>> graph, int target) {
        // code here
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n];
        int ans = 0;

        q.add(0);
        visited[0] = true;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; ++i) {
                assert q.peek() != null;
                int node = q.poll();
                for (int child : graph.get(node)) {
                    if (!visited[child]) {
                        if (child == target) return ans + 1;
                        q.add(child);
                        visited[child] = true;
                    }
                }
            }
            ++ans;
        }

        return -1;
    }
}