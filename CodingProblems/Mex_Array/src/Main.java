// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static BufferedReader br;
    public static PrintWriter ot;


    public static void main(String[] args) throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));
        ot = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int[] a = new int[n];
            s = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(s[i]);
            }

            int[] ans = new Solution().mexArray(n, a);
            for (int x : ans)
                ot.print(x + " ");
            ot.println();


        }
        ot.close();
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
    public int[] mexArray(int n, int[] nums) {
        // Code Here.
        int[] ans = new int[n];
        boolean[] visited = new boolean[n];
        int val = 0;

        Arrays.sort(nums);

        int l = 0;
        int r = n - 1;

        while (l < r) {
            int t = nums[l];
            nums[l] = nums[r];
            nums[r] = t;
            ++l;
            --r;
        }

        for (int i = 0; i < n; ++i) {
            visited[nums[i]] = true;
            while (visited[val]) {
                ++val;
            }
            ans[i] = val;
        }

        return ans;
    }
}