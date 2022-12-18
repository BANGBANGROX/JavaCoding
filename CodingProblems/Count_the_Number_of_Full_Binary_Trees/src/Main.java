//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        int t =
                Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int[] a = new int[(int) (n)];
            String[] inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }

            Solution obj = new Solution();
            System.out.println(obj.numoffbt(a, n));

        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    public int numoffbt(int[] nums, int n) {
        // Your code goes here
        int maxValue = Arrays.stream(nums).max().getAsInt();
        int minValue = Arrays.stream(nums).min().getAsInt();
        boolean[] visited = new boolean[maxValue + 1];
        int[] dp = new int[maxValue + 1];
        int ans = 0;
        final int MOD = (int) 1e9 + 7;

        for (int num : nums) {
            visited[num] = true;
            dp[num] = 1;
        }

        for (int i = minValue; i <= maxValue; ++i) {
            if (!visited[i]) continue;
            for (int j = 2; i * j <= maxValue && j <= i; ++j) {
                int parent = i * j;
                if (!visited[parent]) continue;
                dp[parent] = (dp[parent] + (dp[i] * dp[j]) % MOD) % MOD;
                if (i != j) {
                    dp[parent] = (dp[parent] + (dp[i] * dp[j]) % MOD) % MOD;
                }
            }
            ans = (ans + dp[i]) % MOD;
        }

        return ans;
    }
}