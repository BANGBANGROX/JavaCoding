//{ Driver Code Starts

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            String[] input_line = read.readLine().trim().split("\\s+");
            int[] arr = new int[N];
            for (int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);


            Solution ob = new Solution();

            System.out.println(ob.maxSubarrayXOR(N, arr));


        }
    }
}

// } Driver Code Ends


class Solution {
    public int maxSubarrayXOR(int n, int[] nums) {
        // code here
        if (n == 1) return nums[0];

        int currentXOR = 1;
        int maxXOR = 0;

        for (int i = 0; i < n; ++i) {
            if (i < n - 1 && nums[i] == nums[i + 1]) return nums[i];
            currentXOR = Math.max(nums[i], currentXOR ^ nums[i]);
            maxXOR = Math.max(maxXOR, currentXOR);
        }

        return maxXOR;
    }
}