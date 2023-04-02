//{ Driver Code Starts
//Initial Template for Java


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int T = Integer.parseInt(in.readLine().trim());
        while (T > 0) {
            String[] s = in.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int k = Integer.parseInt(s[1]);
            int[][] a = new int[k][2];
            for (int i = 0; i < k; i++) {
                s = in.readLine().trim().split(" ");
                a[i][0] = Integer.parseInt(s[0]);
                a[i][1] = Integer.parseInt(s[1]);
            }
            Solution g = new Solution();
            long[] res = g.countZero(n, k, a);

            for (long re : res) {
                out.print(re + " ");
            }
            out.println();
            T--;
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java


class Solution {
    long[] countZero(int n, int k, int[][] queries) {
        // code here
        long[] ans = new long[k];
        HashSet<Integer> rowsAffected = new HashSet<>();
        HashSet<Integer> colsAffected = new HashSet<>();
        long countOfZeroes = (long) n * n;

        for (int i = 0; i < k; ++i) {
            int r = queries[i][0] - 1;
            int c = queries[i][1] - 1;
            if (rowsAffected.contains(r) && colsAffected.contains(c)) {
                ans[i] = countOfZeroes;
                continue;
            }
            else if (rowsAffected.contains(r)) {
                countOfZeroes -= (n - rowsAffected.size());
            }
            else if (colsAffected.contains(c)) {
                countOfZeroes -= (n - colsAffected.size());
            }
            else {
                countOfZeroes -= (2L * n - rowsAffected.size() - colsAffected.size() - 1);
            }
            rowsAffected.add(r);
            colsAffected.add(c);
            ans[i] = countOfZeroes;
        }

        return ans;
    }
}