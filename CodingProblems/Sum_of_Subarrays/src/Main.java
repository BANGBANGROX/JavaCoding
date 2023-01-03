//{ Driver Code Starts
//Initial Template for Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        int t =
                Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            long[] a = new long[(int)(n)];
            String[] inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(inputLine[i]);
            }

            Solution obj = new Solution();
            System.out.println(obj.subarraySum(a, n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    public long subarraySum(long[] nums, long n) {
        // code here
        final int MOD = (int) 1e9 + 7;
        long ans = 0;

        for (int i = 0; i < n; ++i) {
            long weight = ((n - i) * (i + 1)) % MOD;
            long value = (nums[i] * weight) % MOD;
            ans = (ans + value) % MOD;
        }

        return ans;
    }
}
