//{ Driver Code Starts
//Initial Template for Java

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
            int[] A = new int[N];
            for (int i = 0; i < N; i++)
                A[i] = Integer.parseInt(input_line[i]);

            Solution ob = new Solution();
            long ans = ob.maxSum(N, A);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    public long maxSum(int n, int[] nums) {
        // code here
        long answer = 0;
        int negCount = 0;
        int zeroCount = 0;
        long minAbsValue = Long.MAX_VALUE;

        for (int i = 0; i < n; ++i) {
            answer += ((long) i + 1) * (n  - i) * Math.abs(nums[i]);
            if (nums[i] < 0) {
                ++negCount;
            }
            if (nums[i] == 0) {
                ++zeroCount;
            }
            minAbsValue = Math.min(minAbsValue,
                    Math.abs(((long) i + 1) * (n  - i) * nums[i]));
        }

        if ((negCount & 1) > 0 && zeroCount == 0) {
            answer -= 2 * minAbsValue;
        }

        return answer;
    }
}