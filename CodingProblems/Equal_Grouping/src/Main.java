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

            int ans = new Solution().evenGrouping(n, a);


            ot.println(ans);


        }
        ot.close();
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
    public int evenGrouping(int n, int[] nums) {
        // Code Here.
        for (int i = 0; i < n; ++i) {
            nums[i] = (int) (Math.log10(nums[i]) / Math.log10(2));
        }

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; ++i) {
            if (!st.isEmpty() && st.peek() == nums[i]) {
                st.pop();
            }
            else st.push(nums[i]);
        }

        return st.size();
    }
}