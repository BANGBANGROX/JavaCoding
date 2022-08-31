//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] s = br.readLine().trim().split(" ");
            int[] nums = new int[n];
            for (int i = 0; i < n; i++)
                nums[i] = Integer.parseInt(s[i]);
            Solution obj = new Solution();
            int[] ans = obj.DistinctSum(nums);
            for (int an : ans) System.out.print(an + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    public int[] DistinctSum(int[] nums) {
        // Code here
        int totalSum = Arrays.stream(nums).sum();
        boolean[] dp = new boolean[totalSum + 1];
        ArrayList<Integer> result = new ArrayList<>();

        dp[0] = true;

        for (int num: nums) {
            for (int sum = totalSum; sum >= num; --sum) {
                dp[sum] |= dp[sum - num];
            }
        }

        for (int i = 0; i <= totalSum; ++i) {
            if (dp[i]) result.add(i);
        }

        return result.stream().mapToInt(i -> i).toArray();
    }
}