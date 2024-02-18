//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray {
    public static int[] input(BufferedReader br, int n) throws IOException {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }
}


class IntMatrix {
    public static int[][] input(BufferedReader br, int n) throws IOException {
        int[][] mat = new int[n][];

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[s.length];
            for (int j = 0; j < s.length; j++)
                mat[i][j] = Integer.parseInt(s[j]);
        }

        return mat;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){

            int N;
            N = Integer.parseInt(br.readLine());


            int[] Values = IntArray.input(br, N);


            int[][] Edges = IntMatrix.input(br, N-1);

            Solution obj = new Solution();
            int res = obj.splittingEdges(N, Values, Edges);

            System.out.println(res);

        }
    }
}

// } Driver Code Ends



class Solution {
    private ArrayList<ArrayList<Integer>> tree;
    private int[][] valuesPrefixSum;
    private int[] values;
    private int[] level;

    private void dfs(int node, int parent, int lev) {
        ++valuesPrefixSum[node][values[node] - 1];
        level[node] = lev;

        for (int child : tree.get(node)) {
            if (child != parent) {
                dfs(child, node, lev + 1);
                for (int i = 0; i < valuesPrefixSum[node].length; ++i) {
                    valuesPrefixSum[node][i] += valuesPrefixSum[child][i];
                }
            }
        }
    }

    public int splittingEdges(int n, int[] values, int[][] edges) {
        // code here
        tree = new ArrayList<>();
        valuesPrefixSum = new int[n][3];
        level = new int[n];
        this.values = values;
        int root = 0;
        int answer = 0;

        for (int i = 0; i < n; ++i) {
            tree.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            tree.get(edge[0]).add(edge[1]);
            tree.get(edge[1]).add(edge[0]);
        }

        dfs(root, -1, 0);

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            if (level[u] < level[v]) {
                u = v;
            }
            if (valuesPrefixSum[root][1] > valuesPrefixSum[u][1] &&
                    valuesPrefixSum[root][2] > valuesPrefixSum[u][2] && valuesPrefixSum[u][1] > 0 && valuesPrefixSum[u][2] > 0) {
                ++answer;
            }
        }

        return answer;
    }
}

