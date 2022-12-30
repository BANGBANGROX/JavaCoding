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
            double[][] Arr = new double[3][4];
            for (int i = 0; i < 3; i++) {
                String[] input_line = read.readLine().trim().split("\\s+");
                for (int j = 0; j < 4; j++) {
                    Arr[i][j] = Double.parseDouble(input_line[j]);
                }
            }
            Solution ob = new Solution();
            double[] ans = ob.myCalculator(Arr);
            for (double an : ans) {
                if (isInteger(an))
                    System.out.print((int) an + " ");
                else
                    System.out.print(an + " ");
            }
            System.out.println();
        }
    }

    public static boolean isInteger(double N) {
        int X = (int) N;
        double temp2 = N - X;
        return !(temp2 > 0);
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    private int transform(double x) {
        if (x < 0) return -1 * ((int) Math.abs(x) + 1);

        return (int) x;
    }

    public double[] myCalculator(double[][] equations) {
        // code here
        double a00 = equations[1][1] * equations[2][2] -
                equations[1][2] * equations[2][1];
        double a01 = equations[1][0] * equations[2][2] -
                equations[1][2] * equations[2][0];
        double a02 = equations[1][0] * equations[2][1] -
                equations[2][0] * equations[1][1];
        double a10 = equations[0][1] * equations[2][2] -
                equations[0][2] * equations[2][1];
        double a11 = equations[0][0] * equations[2][2] -
                equations[0][2] * equations[2][0];
        double a12 = equations[0][0] * equations[2][1] -
                equations[0][1] * equations[2][0];
        double a20 = equations[0][1] * equations[1][2] -
                equations[0][2] * equations[1][1];
        double a21 = equations[0][0] * equations[1][2] -
                equations[0][2] * equations[1][0];
        double a22 = equations[1][1] * equations[0][0] -
                equations[0][1] * equations[1][0];
        double c1 = equations[0][3];
        double c2 = equations[1][3];
        double c3 = equations[2][3];
        double det = equations[0][0] * a00 - equations[0][1] * a01 +
                equations[0][2] * a02;
        double x = (a00 * c1 - a10 * c2 + a20 * c3) / det;
        double y = (-1 * a01 * c1 + a11 * c2 - a21 * c3) / det;
        double z = (a02 * c1 - a12 * c2 + a22 * c3) / det;

        return new double[]{transform(x), transform(y), transform(z)};
    }
}