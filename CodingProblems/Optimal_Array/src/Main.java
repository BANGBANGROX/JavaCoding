//{ Driver Code Starts

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine());
            String[] s = in.readLine().trim().split(" ");
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(s[i]);
            }
            Solution ob = new Solution();
            long[] arr = ob.optimalArray(n, a);
            for (long i : arr) {
                out.print(i + " ");
            }
            out.println();
        }
        out.close();
    }
}
// } Driver Code Ends


class Solution {
    public long[] optimalArray(int n, int[] nums) {
         long[] ans = new long[n];
         long[] prefix = new long[n];

         prefix[0] = nums[0];

         for (int i = 1; i < n; ++i) {
             prefix[i] = prefix[i - 1] + nums[i];
         }

         ans[0] = 0;

         for (int i = 1; i < n; ++i) {
             int idx = (i + 1) / 2;
             int median = nums[idx];
             long leftSum = prefix[idx - 1];
             long rightSum = prefix[i] - prefix[idx];
             ans[i] = rightSum - leftSum;
             if ((i & 1) > 0) {
                 ans[i] += median;
             }
         }

         return ans;
    }
}

