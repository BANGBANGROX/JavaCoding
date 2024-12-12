//{ Driver Code Starts
// Initial Template for Java

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][2];
            for (int i = 0; i < n; i++) {
                a[i][0] = sc.nextInt();
                a[i][1] = sc.nextInt();
            }
            int[] h = new int[2];
            h[0] = sc.nextInt();
            h[1] = sc.nextInt();
            Solution obj = new Solution();
            ArrayList<int[]> ans = obj.insertInterval(a, h);
            System.out.print("[");
            for (int i = 0; i < ans.size(); i++) {
                System.out.print("[");
                System.out.print(ans.get(i)[0] + "," + ans.get(i)[1]);
                System.out.print("]");
                if (i != ans.size() - 1) System.out.print(",");
            }
            System.out.println("]");

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public void sortbyColumn(int[][] a, int c) {
        Arrays.sort(a, Comparator.comparingInt(x -> x[c]));
    }

    public ArrayList<int[]> insertInterval(int[][] intervals,
                                           int[] newInterval) {
        // code here
        int m = intervals.length;

        int[][] arr = new int[m + 1][2];
        for (int i = 0; i < m; i++) {
            arr[i][0] = intervals[i][0];
            arr[i][1] = intervals[i][1];
        }
        arr[m][0] = newInterval[0];
        arr[m][1] = newInterval[1];
        ArrayList<int[]> a = new ArrayList<>();
        int n = arr.length;
        int[] range = new int[2];
        sortbyColumn(arr, 0);
        range[0] = arr[0][0];
        range[1] = arr[0][1];
        for (int i = 1; i < m + 1; i++) {
            if (arr[i][0] <= range[1]) {
                if (arr[i][1] > range[1]) {
                    range[1] = arr[i][1];
                }
            } else if (arr[i][0] > range[1]) {
                int[] temp = new int[2];
                temp[0] = range[0];
                temp[1] = range[1];
                a.add(temp);
                range[0] = arr[i][0];
                range[1] = arr[i][1];
            }
        }
        a.add(range);
        return a;
    }
}
