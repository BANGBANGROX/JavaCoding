//{ Driver Code Starts
//Initial Template for Java

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int[] a = new int[n];
            String[] inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }
            int ans = new Solution().lengthOfLongestAP(a, n);
            System.out.println(ans);
        }
    }
}


// } Driver Code Ends


//User function Template for Java

class Solution {
    int lengthOfLongestAP(int[] nums, int n) {
        // code here
        int[][] dp = new int[1005][10005];
        int ans = 0;

        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                dp[i][nums[i] - nums[j]] = Math.max(dp[i][nums[i] - nums[j]], 1 + dp[j][nums[i] - nums[j]]);
                ans = Math.max(ans, dp[i][nums[i] - nums[j]]);
            }
        }

        return ans + 1;
    }
}
