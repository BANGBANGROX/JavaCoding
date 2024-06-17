//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int p1[] = new int[2];
            int q1[] = new int[2];
            int p2[] = new int[2];
            int q2[] = new int[2];
            String S1[] = read.readLine().split(" ");
            p1[0] = Integer.parseInt(S1[0]);
            p1[1] = Integer.parseInt(S1[1]);
            q1[0] = Integer.parseInt(S1[2]);
            q1[1] = Integer.parseInt(S1[3]);
            String S2[] = read.readLine().split(" ");
            p2[0] = Integer.parseInt(S2[0]);
            p2[1] = Integer.parseInt(S2[1]);
            q2[0] = Integer.parseInt(S2[2]);
            q2[1] = Integer.parseInt(S2[3]);
            Solution ob = new Solution();
            String ans = ob.doIntersect(p1, q1, p2, q2);
            // if(ans)
            System.out.println(ans);
            // else
            // System.out.println("false");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    private double divide(double x, double y) {
        return y != 0 ? x / y : x == 0 ? 1 : Integer.MAX_VALUE;
    }

    public String doIntersect(int[] p1, int[] q1, int[] p2, int[] q2) {
        // code here
        // y - y1 / x - x1 = y2 - y1 / x2 - x1
        // y(x2 - x1) - x(y2 - y1) = y1(x2 - x1) - x1(y2 - y1)
        // a1 / a2 = b1 / b2 != c1 / c2
        double a1 = -1 * (q1[1] - p1[1]);
        double b1 = q1[0] - p1[0];
        double c1 = p1[1] * (q1[0] - p1[0]) - p1[0] * (q1[1] - p1[1]);
        double a2 = -1 * (q2[1] - p2[1]);
        double b2 = q2[0] - p2[0];
        double c2 = p2[1] * (q2[0] - p2[0]) - p2[0] * (q2[1] - p2[1]);
        double a1Bya2 = divide(a1, a2);
        double b1Byb2 = divide(b1, b2);
        double c1Byc2 = divide(c1, c2);

        if (a1Bya2 == b1Byb2 && a1Bya2 != c1Byc2) return "false";

        double x = divide(b2 * c1 - b1 * c2, a1 * b2 - a2 * b1);
        double y = divide(a2 * c1 - a1 * c2, a2 * b1 - a1 * b2);
        double minX = Math.min(Math.min(p1[0], q1[0]), Math.min(p2[0], q2[0]));
        double maxX = Math.max(Math.max(p1[0], q1[0]), Math.max(p2[0], q2[0]));
        double minY = Math.min(Math.min(p1[1], q1[1]), Math.min(p2[1], q2[1]));
        double maxY = Math.max(Math.max(p1[1], q1[1]), Math.max(p2[1], q2[1]));

//        System.out.println(x + " " + y);

        return x >= minX && x <= maxX && y >= minY && y <= maxY ? "true" : "false";
    }
}