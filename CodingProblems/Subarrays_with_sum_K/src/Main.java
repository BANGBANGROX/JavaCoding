//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String[] args)throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String[] input_line = read.readLine().trim().split("\\s+");
            int[] Arr = new int[N];
            for(int i = 0; i < N; i++)
                Arr[i] = Integer.parseInt(input_line[i]);
            int k = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.findSubArraySum(Arr, k));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    public int findSubArraySum(int[] nums, int k) {
        // code here
        int ans = 0;
        int currentSum = 0;
        HashMap<Integer, Integer> count = new HashMap<>();

        for (int num: nums) {
            currentSum += num;
            if (currentSum == k) ++ans;
            ans += count.getOrDefault(currentSum - k, 0);
            count.put(currentSum, count.getOrDefault(currentSum, 0) + 1);
        }

        return ans;
    }
}