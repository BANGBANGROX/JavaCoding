// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
public class Main{
    static BufferedReader br;
    static PrintWriter ot;
    public static void main(String args[]) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        ot = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while(t-- > 0){
            String s[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            s = br.readLine().trim().split(" ");
            int arr[] = new int[n];
            for(int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(s[i]);
            ot.println(new Solution().minJump(arr, n));
        }

        ot.close();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    public int minJump(int[] nums, int n) {
        int lastIndex = 0;
        int ans = 0;

        for (int i = 1; i < n; ++i) {
            if (nums[i] % 2 == 0 || nums[i] % 3 == 0) {
                ans = Math.max(ans, i - lastIndex);
                lastIndex = i;
            }
        }

        return ans;
    }
}