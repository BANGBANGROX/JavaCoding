// { Driver Code Starts
//Initial Template for Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Main {
    static BufferedReader br;
    static PrintWriter ot;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        ot = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int M = Integer.parseInt(s[1]);
            int[] a = new int[n];
            s = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(s[i]);
            }
            ot.println(new Solution().maxChocolates(a, n, M));
        }

        ot.close();
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
    private int[] chocolateNums;
    private int m;

    private boolean check(int num) {
        int cnt = 0;

        for (int choco : chocolateNums) {
            cnt += (choco / num);
            if (cnt >= m) return true;
        }

        return false;
    }

    public int maxChocolates(int[] chocolateNums, int n, int m) {
        // Code Here.
        this.chocolateNums = chocolateNums;
        this.m = m;
        int l = 1;
        int r = (int) 1e9 + 5;
        int ans = 0;

        while (l <= r) {
            int mid = (l + ((r - l) >> 1));
            if (check(mid)) {
                ans = mid;
                l = mid + 1;
            }
            else r = mid - 1;
        }

        return ans;
    }
}