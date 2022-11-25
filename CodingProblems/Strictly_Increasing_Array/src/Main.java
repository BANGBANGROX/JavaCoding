//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
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
            for(int i = 0; i < n; i++)
                nums[i] = Integer.parseInt(s1[i]);
            Solution ob = new Solution();
            long ans = ob.min_operations(nums);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    private int upperBound(ArrayList<Integer> nums, int key) {
        int n = nums.size();
        int l = 0;
        int r = n - 1;

        while (l <= r) {
            int mid = (l + ((r - l) >> 1));
            if (nums.get(mid) <= key) l = mid + 1;
            else r = mid - 1;
        }

        return l;
    }

    public int min_operations(int[] nums) {
        // Code here
        ArrayList<Integer> dp = new ArrayList<>();
        int n = nums.length;

        for (int i = 0; i < n; ++i) {
            nums[i] -= i;
        }

        dp.add(nums[0]);

        for (int i = 1; i < n; ++i) {
            int idx = upperBound(dp, nums[i]);
            if (idx == dp.size()) dp.add(nums[i]);
            else dp.set(idx, nums[i]);
        }

        return n - dp.size();
    }
}