//{ Driver Code Starts
import java.io.*;
import java.util.*;

class IntMatrix {
    public static int[][] input(BufferedReader br, int n) throws IOException {
        int[][] mat = new int[n][];

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[s.length];
            for (int j = 0; j < s.length; j++)
                mat[i][j] = Integer.parseInt(s[j]);
        }

        return mat;
    }

}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n;
            n = Integer.parseInt(br.readLine());

            int[][] intervals = IntMatrix.input(br, n);

            Solution obj = new Solution();
            int res = obj.maximum_profit(n, intervals);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


class Solution {
    private int lowerBound(int[][] nums, int key) {
        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int mid = (l + ((r - l) >> 1));
            if (nums[mid][0] <= key) l = mid + 1;
            else r = mid - 1;
        }

        return l;
    }

    public int maximum_profit(int n, int[][] intervals) {
        // code here
        int[] dp = new int[n];

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        for (int i = n - 1; i >= 0; --i) {
            int idx = lowerBound(intervals, intervals[i][1]);
            dp[i] = intervals[i][2];
            if (idx < n) {
                dp[i] += dp[idx];
            }
            if (i < n - 1) dp[i] = Math.max(dp[i], dp[i + 1]);
        }

        return dp[0];
    }
}
