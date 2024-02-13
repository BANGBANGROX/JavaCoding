//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntMatrix
{
    public static int[][] input(BufferedReader br, int n) throws IOException
    {
        int[][] mat = new int[n][];

        for(int i = 0; i < n; i++)
        {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[s.length];
            for(int j = 0; j < s.length; j++)
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

            int n;
            n = Integer.parseInt(br.readLine());


            int m;
            m = Integer.parseInt(br.readLine());


            int[][] edges = IntMatrix.input(br, m);

            Solution obj = new Solution();
            int res = obj.vertexCover(n, edges);

            System.out.println(res);

        }
    }
}

// } Driver Code Ends


class Solution {
    private int[] dp;
    private ArrayList<ArrayList<Integer>> graph;
    private int n;

    private int vertexCoverHandler(int mask) {
        if (dp[mask] != -1) return dp[mask];

        boolean canAdd = false;
        int result = (int) 1e9;

        for (int i = 0; i < n; ++i) {
            if ((mask & (1 << i)) == 0) {
                boolean flag = false;
                for (int child : graph.get(i)) {
                    if ((mask & (1 << child)) == 0) {
                        flag = true;
                        break;
                    }
                }
                if (flag) {
                    canAdd = true;
                    break;
                }
            }
        }

        if (!canAdd) {
            return Integer.bitCount(mask);
        }

        for (int i = 0; i < n; ++i) {
            if ((mask & (1 << i)) == 0) {
                result = Math.min(result, vertexCoverHandler(mask | (1 << i)));
            }
        }

        return dp[mask] = result;
    }

    public int vertexCover(int n, int[][] edges) {
        // code here
        this.n = n;
        graph = new ArrayList<>();
        dp = new int[(1 << n)];

        Arrays.fill(dp, -1);

        for (int i = 0; i < n; ++i) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0] - 1).add(edge[1] - 1);
            graph.get(edge[1] - 1).add(edge[0] - 1);
        }

        return vertexCoverHandler(0);
    }
}

