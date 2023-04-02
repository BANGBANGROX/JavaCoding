//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine().trim());

        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine().trim());
            int[] arr = new int[n];
            String[] s = in.readLine().trim().split(" ");
            for (int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(s[i]);

            out.println(new Solution().maxLength(arr));
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    /* Function to return the length of the
       longest subarray with positive product */
    int maxLength(int[] nums) {
        //code here
        nums = Arrays.copyOf(nums, nums.length + 1);

        int n = nums.length;
        int l = -1;
        int r = -1;
        int lastNonZeroIndex = 0;
        int negCount = 0;
        int ans = 0;

        for (int i = 0; i < n; ++i) {
            if (nums[i] < 0) {
                ++negCount;
                if (l == -1) l = i;
                r = i;
            }
            else if (nums[i] == 0) {
                if (negCount % 2 == 0) {
                    ans = Math.max(ans, i - lastNonZeroIndex);
                }
                else {
                    ans = Math.max(ans, Math.max(i - l - 1, r - lastNonZeroIndex));
                }
                lastNonZeroIndex = i + 1;
                negCount = 0;
                l = -1;
                r = -1;
            }
        }

        return ans;
    }
}