//{ Driver Code Starts
// Initial Template for Java

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        while (t-- > 0) {

            int n;
            n = sc.nextInt();

            int k;
            k = sc.nextInt();

            int[] v = new int[n];
            for (int i = 0; i < n; i++) v[i] = sc.nextInt();

            Solution obj = new Solution();
            int res = obj.solve(n, k, v);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    private boolean check(int k, int[] stalls, int n, int distance) {
        --k;
        int previousCow = stalls[0];

        for (int i = 1; i < n; ++i) {
            if (stalls[i] - previousCow >= distance) {
                --k;
                previousCow = stalls[i];
            }
            if (k == 0) return true;
        }

        return false;
    }

    public int solve(int n, int k, int[] stalls) {
        Arrays.sort(stalls);

        int l = 1;
        int r = (int) 1e9 + 5;
        int ans = -1;

        while (l <= r) {
            int mid = (l + ((r - l) >> 1));
            if (check(k, stalls, n, mid)) {
                ans = mid;
                l = mid + 1;
            } else r = mid - 1;
        }

        return ans;
    }
}