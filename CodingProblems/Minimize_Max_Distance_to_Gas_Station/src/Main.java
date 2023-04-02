//{ Driver Code Starts
//Initial Template for Java

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            int k = sc.nextInt();
            Solution obj = new Solution();
            double ans = obj.findSmallestMaxDist(a, k);
            System.out.printf("%.2f", ans);
            System.out.println();
        }
    }
}


// } Driver Code Ends


//User function Template for Java

class Solution {
    private boolean check(int[] stations, int k, double distance) {
         int count = 0;
         int n = stations.length;

         for (int i = 1; i < n; ++i) {
             int gap = stations[i] - stations[i - 1];
             count += (int)(gap / distance);
             if (count > k) return false;
         }

         return true;
    }

    public double findSmallestMaxDist(int[] stations, int k) {
        // code here
        int n = stations.length;
        double l = 1;
        double r = stations[n - 1] - stations[0];
        double ans = -1;
        final double DIFF = 1e-6;

        while (r - l >= DIFF) {
            double mid = (l + r) / 2;
            if (check(stations, k, mid)) {
                ans = mid;
                r = mid;
            }
            else l = mid;
        }

        return ans;
    }
}
     