//{ Driver Code Starts
//Initial Template for Java

//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            long[] a = new long[(int) (n)];
            long[] b = new long[(int) (n)];


            String[] inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(inputLine[i]);
            }
            String[] inputLine1 = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                b[i] = Long.parseLong(inputLine1[i]);
            }


            Solution obj = new Solution();
            System.out.println(obj.getMin(a, b, n));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {

    public long getMin(long[] nums1, long[] nums2, long n) {
        // Your code goes here
        if (n == 1) return -1;

        long[][] indexValuesNums1 = new long[(int) n][];
        long[][] indexValuesNums2 = new long[(int) n][];

        for (int i = 0; i < (int) n; ++i) {
            indexValuesNums1[i] = new long[]{nums1[i], i};
            indexValuesNums2[i] = new long[]{nums2[i], i};
        }

        Arrays.sort(indexValuesNums1, (a, b) ->
                (int) (a[0] != b[0] ? (int) a[0] - b[0] : (int) a[1] - b[1]));
        Arrays.sort(indexValuesNums2, (a, b) ->
                (int) (a[0] != b[0] ? (int) a[0] - b[0] : (int) a[1] - b[1]));

        if (indexValuesNums1[0][1] != indexValuesNums2[0][1]) {
            return indexValuesNums1[0][0] + indexValuesNums2[0][0];
        }

        return Math.min(indexValuesNums1[1][1] + indexValuesNums2[0][1],
                indexValuesNums1[0][1] + indexValuesNums2[1][1]);
    }
}