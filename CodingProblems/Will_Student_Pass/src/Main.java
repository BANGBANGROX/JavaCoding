// { Driver Code Starts
//Initial Template for Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Main {
    static BufferedReader br;
    static PrintWriter ot;
    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        ot = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while(t-- > 0){
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int x = Integer.parseInt(s[2]);
            s = br.readLine().trim().split(" ");
            int[] p = new int[n];
            for(int i = 0; i < n; i++)
                p[i] = Integer.parseInt(s[i]);
            int[][] a = new int[n][m];
            for(int i = 0; i < n; i++){
                s = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    a[i][j] = Integer.parseInt(s[j]);
                }
            }
            ot.println(new Solution().minimumCost(n, m, x, p, a));
        }
        ot.close();
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
    public int minimumCost(int m, int n, int x, int[] p, int[][] a) {
        // Code Here.
        int ans = Integer.MAX_VALUE;

        for (int i = 1; i < (1 << m); ++i) {
            int currentPrice = 0;
            for (int j = 0; j < m; ++j) {
                if ((i & (1 << j)) > 0) {
                    currentPrice += p[j];
                }
            }
            boolean poss = true;
            for (int j = 0; j < n; ++j) {
                int score = 0;
                for (int k = 0; k < m; ++k) {
                    if ((i & (1 << k)) > 0) {
                        score += a[k][j];
                    }
                }
                if (score < x) {
                    poss = false;
                    break;
                }
            }
            if (poss) {
                ans = Math.min(ans, currentPrice);
            }
        }

        return ans == Integer.MAX_VALUE ? x == 0 ? 0 : -1 : ans;
    }
}