//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

public class Main
{
    public static void main(String args[]) throws IOException {

        BufferedReader read =
                new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int V = Integer.parseInt(str[0]);
            int E = Integer.parseInt(str[1]);

            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

            int i=0;
            while (i++<E) {
                String S[] = read.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                int w = Integer.parseInt(S[2]);
                ArrayList<Integer> t1 = new ArrayList<>();
                t1.add(u);
                t1.add(v);
                t1.add(w);
                adj.add(t1);
            }

            int S = Integer.parseInt(read.readLine());

            Solution ob = new Solution();

            int[] ptr = ob.bellman_ford(V, adj, S);

            for(i=0; i<V; i++)
                System.out.print(ptr[i] + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

/*
 *   adj: vector of vectors which represents the graph
 *   S: source vertex to start traversing graph with
 *   V: number of vertices
 */
class Solution {
    public int[] bellman_ford(int n, ArrayList<ArrayList<Integer>> graph, int src) {
        // Write your code here
        int[] ans = new int[n];
        final int INF = (int)1e8;

        Arrays.fill(ans, INF);
        ans[src] = 0;

        for (int i = 0; i < n; ++i) {
            for (ArrayList<Integer> edge : graph) {
                int u = edge.get(0);
                int v = edge.get(1);
                int wt = edge.get(2);
                if (ans[u] != INF && ans[v] > ans[u] + wt) {
                    ans[v] = ans[u] + wt;
                }
            }
        }

        return ans;
    }
}

