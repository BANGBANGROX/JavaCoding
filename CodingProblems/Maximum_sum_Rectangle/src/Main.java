// { Driver Code Starts
// Initial Template for Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader read =
                new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N, M;
            String[] S = read.readLine().split(" ");
            N = Integer.parseInt(S[0]);
            M = Integer.parseInt(S[1]);
            int[][] a = new int[N][M];
            for (int i = 0; i < N; i++) {
                String[] s = read.readLine().split(" ");
                for (int j = 0; j < M; j++) a[i][j] = Integer.parseInt(s[j]);
            }
            Solution ob = new Solution();
            System.out.println(ob.maximumSumRectangle(N, M, a));
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution {
    private int maxSumSubArray(int[] nums) {
          int currentSum = 0;
          int maxSum = Integer.MIN_VALUE;

          for (int num : nums) {
              currentSum = Math.max(num, currentSum + num);
              maxSum = Math.max(maxSum, currentSum);
          }

          return maxSum;
    }

    public int maximumSumRectangle(int m, int n, int[][] mat) {
        // code here
        int ans = Integer.MIN_VALUE;

        for (int i = 0; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                mat[i][j] += mat[i][j - 1];
            }
        }

        for (int i = 0; i < n; ++i) {
            for (int j = i; j < n; ++j) {
                int[] nums = new int[m];
                int ptr = 0;
                for (int k = 0; k < m; ++k) {
                    nums[ptr] = mat[k][j] - (i == 0 ? 0 : mat[k][i - 1]);
                    ++ptr;
                }
                ans = Math.max(ans, maxSumSubArray(nums));
            }
        }

        return ans;
    }
}