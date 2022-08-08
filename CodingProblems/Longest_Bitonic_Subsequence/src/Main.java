//{ Driver Code Starts
//Initial Template for Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String s = br.readLine().trim();
            String[] s1 = s.split(" ");
            int[] nums = new int[n];
            for(int i = 0; i < s1.length; i++)
                nums[i] = Integer.parseInt(s1[i]);
            Solution ob = new Solution();
            int ans = ob.LongestBitonicSequence(nums);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    public int LongestBitonicSequence(int[] nums) {
        // Code here
        int n = nums.length;
        int[] lis = new int[n];
        int[] lds = new int[n];
        int ans = 0;

        for (int i = 0; i < n; ++i) {
            lis[i] = 1;
            for (int j = 0; j < i; ++j) {
                if (nums[i] > nums[j]) {
                    lis[i] = Math.max(lis[i], 1 + lis[j]);
                }
             }
        }

        for (int i = n - 1; i >= 0; --i) {
            lds[i] = 1;
            for (int j = n - 1; j > i; --j) {
                if (nums[i] > nums[j]) {
                    lds[i] = Math.max(lds[i], 1 + lds[j]);
                }
            }
        }

        for (int i = 0; i < n - 1; ++i) {
            ans = Math.max(ans, lis[i] + lds[i] - 1);
        }

        return ans;
    }
}