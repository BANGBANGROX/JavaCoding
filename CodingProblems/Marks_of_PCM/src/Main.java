//{ Driver Code Starts
//Initial Template for Java

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[] phy = new int[n];
            int[] chem = new int[n];
            int[] math = new int[n];

            for (int i = 0; i < n; ++i) {
                phy[i] = sc.nextInt();
                chem[i] = sc.nextInt();
                math[i] = sc.nextInt();
            }

            Solution ob = new Solution();

            ob.customSort(phy, chem, math, n);
            for (int i = 0; i < n; ++i)
                System.out.println(phy[i] + " " + chem[i] + " " + math[i]);

        }

    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    public void customSort(int[] phy, int[] chem, int[] math, int n) {
        // your code here
        int[][] marks = new int[n][3];

        for (int i = 0; i < n; ++i) {
            marks[i][0] = phy[i];
            marks[i][1] = chem[i];
            marks[i][2] = math[i];
        }

        Arrays.sort(marks, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] != b[1] ?
                b[1] - a[1] : a[2] - b[2]);

        for (int i = 0; i < n; ++i) {
            phy[i] = marks[i][0];
            chem[i] = marks[i][1];
            math[i] = marks[i][2];
        }
    }
}
