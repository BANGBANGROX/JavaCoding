//{ Driver Code Starts

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class IntArray {
    public static int[] input(BufferedReader br) throws IOException {
        String[] s = br.readLine().trim().split(" ");
        int n = s.length;
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);

        return a;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int[] arr = IntArray.input(br);

            Solution obj = new Solution();
            int res = obj.maxValue(arr);

            System.out.println(res);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    private int[] arr;
    private int n;

    private int getMaxValueForRange(int start, int end) {
        int[] dp = new int[n];

        dp[start] = arr[start];

        if (start + 1 < n) {
            dp[start + 1] = Math.max(arr[start], arr[start + 1]);
        }

        for (int i = start + 2; i <= end; ++i) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + arr[i]);
        }

        return dp[end];
    }

    public int maxValue(int[] arr) {
        // code here
        this.arr = arr;
        n = arr.length;

        return Math.max(getMaxValueForRange(0, n - 2), getMaxValueForRange(1, n - 1));
    }
}
