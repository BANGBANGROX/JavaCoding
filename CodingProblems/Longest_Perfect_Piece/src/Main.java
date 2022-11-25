//{ Driver Code Starts
//Initial Template for Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read =
                new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());

            String[] S = read.readLine().split(" ");
            int[] arr = new int[N];

            for (int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            System.out.println(ob.longestPerfectPiece(arr, N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    public int longestPerfectPiece(int[] nums, int n) {
        // code here
        int i = 0;
        int j = 0;
        int ans = 0;

        while (i < n) {
            if (Math.abs(nums[i] - nums[j]) <= 1) {
                ans = Math.max(ans, i - j + 1);
                ++i;
            }
            else {
                while (j < n && Math.abs(nums[i] - nums[j]) > 1) {
                    ++j;
                }
            }
        }

        return ans;
    }
}