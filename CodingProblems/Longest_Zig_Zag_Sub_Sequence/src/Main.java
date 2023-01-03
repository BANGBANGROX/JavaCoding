//{ Driver Code Starts
//Initial Template for Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] S = br.readLine().split(" ");
            int[] nums = new int[n];
            for (int i = 0; i < n; i++)
                nums[i] = Integer.parseInt(S[i]);
            Solution ob = new Solution();
            int ans = ob.ZigZagMaxLength(nums);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    public int ZigZagMaxLength(int[] nums) {
        // code here
        int n = nums.length;
        int incSeqLength = 1;
        int decSeqLength = 1;

        for (int i = 1; i < n; ++i) {
            if (nums[i] > nums[i - 1]) incSeqLength = decSeqLength + 1;
            else if (nums[i] < nums[i - 1]) decSeqLength = incSeqLength + 1;
        }

        return Math.max(incSeqLength, decSeqLength);
    }
}