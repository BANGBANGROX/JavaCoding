//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String[] input_line = read.readLine().trim().split("\\s+");
            int[] arr = new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);


            Solution ob = new Solution();
            if(ob.is1winner(N,arr))
                System.out.println("1");
            else
                System.out.println("0");

        }
    }
}

// } Driver Code Ends


class Solution {
    private int[][] dp;

    private int scoreDifference(int l, int r, int[] nums) {
        if (l > r) return 0;

        if (l == r) return nums[l];

        if (dp[l][r] != Integer.MAX_VALUE) return dp[l][r];

        int val1 = nums[l] - scoreDifference(l + 1, r, nums);
        int val2 = nums[r] - scoreDifference(l, r - 1, nums);

        return dp[l][r] = Math.max(val1, val2);
    }

    public boolean is1winner(int n, int[] nums){
        // code here
        dp = new int[n][n];

        for (int i = 0; i < n; ++i) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        return scoreDifference(0, n - 1, nums) > 0;
    }
}