//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        while (test-- > 0) {
            String[] str = br.readLine().trim().split(" ");
            int n = Integer.parseInt(str[0]);
            int k = Integer.parseInt(str[1]);
            int[] sweetness = new int[n];
            str = br.readLine().trim().split(" ");
            int i = 0;
            for (String s : str) {
                sweetness[i++] = Integer.parseInt(s);
            }
            Solution obj = new Solution();
            System.out.println(obj.maxSweetness(sweetness, n, k));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    private int[] sweetness;
    private int n;

    private boolean check(long value, int k) {
        long currentSum = 0;

        for (int i = 0; i < n; ++i) {
            if (currentSum >= value) {
                --k;
                if (k == 0) return true;
                currentSum = 0;
            }
            currentSum += sweetness[i];
        }

        if (currentSum >= value) --k;

        return k == 0;
    }

    public int maxSweetness(int[] sweetness, int n, int k) {
        // Write your code here.
        this.sweetness = sweetness;
        this.n = n;
        long l = 1;
        long r = Arrays.stream(sweetness).sum();
        long answer = -1;

        ++k;

        while (l <= r) {
            long mid = (l + ((r - l) >> 1));
            if (check(mid, k)) {
                answer = mid;
                l = mid + 1;
            }
            else r = mid - 1;
        }

        return (int) answer;
    }
}