//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            String[] input_line = read.readLine().trim().split("\\s+");
            int[] Arr = new int[N];
            for (int i = 0; i < N; i++)
                Arr[i] = Integer.parseInt(input_line[i]);
            int X = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.closest3Sum(Arr, N, X));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    public int closest3Sum(int[] nums, int n, int k) {
        // code here
        Arrays.sort(nums);
        int minDiff = Integer.MAX_VALUE;
        int ans = -1;

        for (int i = 0; i < n - 1; ++i) {
            int l = i + 1;
            int r = n - 1;
            while (l < r) {
                int sum = nums[l] + nums[r] + nums[i];
                if (sum == k) return sum;
                if (sum > k) {
                    int currentDiff = sum - k;
                    if (currentDiff < minDiff) {
                        ans = sum;
                        minDiff = currentDiff;
                    }
                    --r;
                }
                else {
                    int currentDiff = k - sum;
                    if (currentDiff < minDiff) {
                        ans = sum;
                        minDiff = currentDiff;
                    }
                    ++l;
                }
            }
        }

        return ans;
    }
}