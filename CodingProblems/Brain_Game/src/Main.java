// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String s = br.readLine().trim();
            String[] S = s.split(" ");
            int[] nums = new int[n];
            for(int i = 0; i < n; i++){
                nums[i] = Integer.parseInt(S[i]);
            }
            Solution ob = new Solution();
            boolean ans = ob.brainGame(nums);
            if(ans)
                System.out.println("A");
            else
                System.out.println("B");
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    public boolean brainGame(int[] nums) {
        // Code here
        int ans = 0;
        int N = Arrays.stream(nums).max().getAsInt() + 1;
        int[] factors = new int[N];

        for (int i = 2; i < N; ++i) {
            for (int j = 2 * i; j < N; j += i) {
                factors[j] = Math.max(factors[j], factors[i] + 1);
            }
        }

        for (int num : nums) {
            ans ^= factors[num];
        }

        return ans != 0;
    }
}