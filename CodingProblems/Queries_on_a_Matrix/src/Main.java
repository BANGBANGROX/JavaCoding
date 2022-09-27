//{ Driver Code Starts
// Initial Template for Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int q = Integer.parseInt(s[1]);
            int[][] Queries = new int[q][4];
            for (int i = 0; i < q; i++) {
                String[] s1 = br.readLine().trim().split(" ");
                for (int j = 0; j < 4; j++)
                    Queries[i][j] = Integer.parseInt(s1[j]);
            }
            Solution obj = new Solution();
            int[][] ans = obj.solveQueries(n, Queries);
            for (int[] an : ans) {
                for (int i : an) {
                    out.print(i + " ");
                }
                out.println();
            }
        }
        out.close();
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int[][] solveQueries(int n, int[][] queries) {
        // Code here
        int[][] ans = new int[n][n];

        for (int[] q: queries) {
            for (int r = q[0]; r <= q[2]; ++r) {
                ++ans[r][q[1]];
                if (q[3] < n - 1) --ans[r][q[3] + 1];
            }
        }

        for (int i = 0; i < n; ++i) {
            for (int j = 1; j < n; ++j) {
                ans[i][j] += ans[i][j - 1];
            }
        }

        return ans;
    }
}