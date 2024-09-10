//{ Driver Code Starts
// Initial Template for Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0) {
            String[] A = in.readLine().trim().split(" ");

            Solution ob = new Solution();
            System.out.println(ob.isCircle(A));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    private List<List<Integer>> graph;
    private boolean[] visited;

    private void dfs(int node) {
        visited[node] = true;

        for (int child : graph.get(node)) {
            if (!visited[child]) {
                dfs(child);
            }
        }
    }

    public int isCircle(String[] arr) {
        // code here
        graph = new ArrayList<>();
        visited = new boolean[26];
        int[] inDegree = new int[26];
        int[] outDegree = new int[26];

        for (int i = 0; i < 26; ++i) {
            graph.add(new ArrayList<>());
        }

        for (String word : arr) {
            int u = word.charAt(0) - 'a';
            int v = word.charAt(word.length() - 1) - 'a';
            graph.get(u).add(v);
            ++inDegree[v];
            ++outDegree[u];
        }

        for (int i = 0; i < 26; ++i) {
            if (inDegree[i] != outDegree[i]) {
                return 0;
            }
        }

        dfs(arr[0].charAt(0) - 'a');

        for (int i = 0; i < 26; ++i) {
            if (!visited[i] && inDegree[i] > 0) {
                return 0;
            }
        }

        return 1;
    }
}