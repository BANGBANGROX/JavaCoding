//{ Driver Code Starts

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        int t =
                Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            String[] inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            System.out.println(new Solution().maxIndexDiff(arr, n));
        }
    }
}
// } Driver Code Ends


class Solution {
    int maxIndexDiff(int[] nums, int n) {
        // code here
        int[] prefixMin = new int[n];
        int ans = 0;
        int j = n - 1;

        prefixMin[0] = nums[0];

        for (int i = 1; i < n; ++i) {
            prefixMin[i] = Math.min(prefixMin[i - 1], nums[i]);
        }

        for (int i = n - 1; i >= 0; --i) {
            while (j >= 0 && prefixMin[j] > nums[i]) --j;
            ans = Math.max(ans, i - j - 1);
        }

        return ans;
    }
}