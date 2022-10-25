//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            String[] input_line = read.readLine().trim().split("\\s+");
            int N = Integer.parseInt(input_line[0]);
            int M = Integer.parseInt(input_line[1]);

            input_line = read.readLine().trim().split("\\s+");
            ArrayList<ArrayList<Integer>> Edges = new ArrayList<>();
            for (int i = 0; i < M; i++) {
                ArrayList<Integer> e = new ArrayList<>();
                e.add(Integer.parseInt(input_line[2 * i]));
                e.add(Integer.parseInt(input_line[2 * i + 1]));
                Edges.add(e);
            }
            Solution ob = new Solution();
            if (ob.check(N, Edges)) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    public boolean check(int n, ArrayList<ArrayList<Integer>> edges) {
        // code here
        boolean[][] adjMatrix = new boolean[n][n];
        boolean[][] dp = new boolean[n][1 << n];

        for (ArrayList<Integer> edge : edges) {
            adjMatrix[edge.get(0) - 1][edge.get(1) - 1] = true;
            adjMatrix[edge.get(1) - 1][edge.get(0) - 1] = true;
        }

        for (int i = 0; i < n; ++i) {
            dp[i][1 << i] = true;
        }

        for (int i = 0; i < (1 << n); ++i) {
            for (int j = 0; j < n; ++j) {
                if ((i & (1 << j)) > 0) {
                    for (int k = 0; k < n; ++k) {
                        if ((i & (1 << k)) > 0 &&
                                adjMatrix[k][j] && k != j && dp[k][i ^ (1 << j)]) {
                            dp[j][i] = true;
                            break;
                        }
                    }
                }
            }
        }

        for (int i = 0; i < n; ++i) {
            if (dp[i][(1 << n) - 1]) return true;
        }

        return false;
    }
}