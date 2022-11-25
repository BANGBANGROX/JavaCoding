//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String[] input_line1 = read.readLine().trim().split("\\s+");
            int k = Integer.parseInt(input_line1[0]);
            int n = Integer.parseInt(input_line1[1]);
            String[] input_line = read.readLine().trim().split("\\s+");
            int[] arr = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(input_line[i]);

            Solution ob = new Solution();
            System.out.println(ob.minTime(arr, k));
        }
    }
}


// } Driver Code Ends


//User function Template for Java

class Solution {
    private boolean check(int[] arr, long time, int k) {
        long currentSum = 0;

        for (int x : arr) {
           if (x > time) return false;
           if (currentSum + x <= time) {
               currentSum += x;
           }
           else {
               if (k == 0) return false;
               currentSum = x;
               --k;
           }
        }

        return true;
    }

    public long minTime(int[] arr, int k) {
        //code here
        long l = 1;
        long r = Arrays.stream(arr).sum();

        while (l <= r) {
            long mid = (l + ((r - l) >> 1));
            if (check(arr, mid, k)) r = mid - 1;
            else l = mid + 1;
        }

        return l;
    }
}


