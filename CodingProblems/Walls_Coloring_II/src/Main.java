//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        while (test-- > 0) {
            String[] str = br.readLine().trim().split(" ");
            int n = Integer.parseInt(str[0]);
            int k = Integer.parseInt(str[1]);
            int[][] costs = new int[n][k];
            for (int i = 0; i < n; i++) {
                str = br.readLine().trim().split(" ");
                for (int j = 0; j < k; j++) {
                    costs[i][j] = Integer.parseInt(str[j]);
                }
            }
            Solution obj = new Solution();
            System.out.println(obj.minCost(costs));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    public int minCost(int[][] costs) {
        //Write your code here
        int n = costs.length;
        int k = costs[0].length;

        if (k == 1) {
            return n == 1 ? costs[0][0] : -1;
        }

        int[][] dp = new int[n][k];
        int lastRowMin = Integer.MAX_VALUE;
        int lastRowSecondMin = Integer.MAX_VALUE;
        int lastRowMinColor = -1;

        for (int i = 0; i < k; ++i) {
            dp[0][i] = costs[0][i];
            if (lastRowMin > dp[0][i]) {
                lastRowSecondMin = lastRowMin;
                lastRowMin = dp[0][i];
                lastRowMinColor = i;
            }
            else if (lastRowSecondMin > dp[0][i]) {
                lastRowSecondMin = dp[0][i];
            }
        }

        for (int i = 1; i < n; ++i) {
            int currentRowMin = Integer.MAX_VALUE;
            int currentRowSecondMin = Integer.MAX_VALUE;
            int currentRowMinColor = -1;
            for (int j = 0; j < k; ++j) {
                if (j != lastRowMinColor) {
                    dp[i][j] = lastRowMin + costs[i][j];
                }
                else {
                    dp[i][j] = lastRowSecondMin + costs[i][j];
                }
                if (currentRowMin > dp[i][j]) {
                    currentRowSecondMin = currentRowMin;
                    currentRowMin = dp[i][j];
                    currentRowMinColor = j;
                }
                else if (currentRowSecondMin > dp[i][j]) {
                    currentRowSecondMin = dp[i][j];
                }
            }
            lastRowMin = currentRowMin;
            lastRowMinColor = currentRowMinColor;
            lastRowSecondMin = currentRowSecondMin;
        }

        return Arrays.stream(dp[n - 1]).min().getAsInt();
    }
}