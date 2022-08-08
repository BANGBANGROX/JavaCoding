//{ Driver Code Starts
import java.util.*;

import java.lang.Math;
import java.io.*;
class Subarray
{
    public static void main(String[] args)throws IOException
    {
        //     Scanner sc = new Scanner(System.in);
        // 	int t = sc.nextInt();

        //reading input using BufferedReader class
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        //taking total testcases
        int t = Integer.parseInt(read.readLine());
        while(t-->0)
        {
            //taking number of elements
            int n = Integer.parseInt(read.readLine());
            int[] a = new int[n];

            String str[] = read.readLine().trim().split(" ");

            //inserting elements to the array
            for(int i = 0;i < n; i++)
                a[i] = Integer.parseInt(str[i]);

            Solution g = new Solution();

            //calling method maxSumSubarray() of
            //class GfG
            System.out.println(g.maxSumSubarray(a , n));
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/


class Solution {
    //Function to return maximum sum subarray by removing at most one element.
    public int maxSumSubarray(int[] nums, int n) {
        //add code here.

        if (n == 1) return nums[0];

        int[] prefix = new int[n + 1];
        int[] suffix = new int[n + 1];
        int ans = Integer.MIN_VALUE;

        for (int i = 0; i < n; ++i) {
            prefix[i + 1] = Math.max(prefix[i] + nums[i], nums[i]);
        }

        for (int i = n - 1; i >= 0; --i) {
            suffix[i] = Math.max(suffix[i + 1] + nums[i], nums[i]);
        }

        for (int i = 0; i < n; ++i) {
            ans = Math.max(ans, Math.max(prefix[i + 1], Math.max(suffix[i],
                    Math.max(prefix[i] + suffix[i], prefix[i] + suffix[i + 1]))));
        }

        return ans;
    }
}

