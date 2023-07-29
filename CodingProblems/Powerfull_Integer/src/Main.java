//{ Driver Code Starts
//Initial Template for Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine().trim());
            int[][] a = new int[n][2];
            for (int i = 0; i < n; i++) {
                String[] s = in.readLine().trim().split(" ");
                a[i][0] = Integer.parseInt(s[0]);
                a[i][1] = Integer.parseInt(s[1]);
            }
            int k = Integer.parseInt(in.readLine().trim());
            Solution ob = new Solution();
            out.println(ob.powerfulInteger(n, a, k));
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    public int powerfulInteger(int n, int[][] intervals, int k) {
        int maximumIntervalValue = Integer.MIN_VALUE;
        int answer = -1;

        for (int[] interval : intervals) {
            maximumIntervalValue = Math.max(maximumIntervalValue, interval[1]);
        }

        int[] count = new int[maximumIntervalValue + 2];

        for (int i = 0; i < n; ++i) {
            int l = intervals[i][0];
            int r = intervals[i][1];
            ++count[l];
            --count[r + 1];
        }

        for (int i = 1; i <= maximumIntervalValue; ++i) {
            count[i] += count[i - 1];
            if (count[i] >= k) {
                answer = i;
            }
        }

        return answer;
    }
}