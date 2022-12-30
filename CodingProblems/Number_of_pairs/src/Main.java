//{ Driver Code Starts

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int m = Integer.parseInt(inputLine[0]);
            int n = Integer.parseInt(inputLine[1]);
            int[] X = new int[m], Y = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < m; i++) {
                X[i] = Integer.parseInt(inputLine[i]);
            }
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                Y[i] = Integer.parseInt(inputLine[i]);
            }


            long ans = new Solution().countPairs(X, Y, n);
            System.out.println(ans);
        }
    }
}


// } Driver Code Ends



class Solution {
    private int upperBound(int[] nums, int k) {
        int n = nums.length;
        int l = 0;
        int r = n - 1;

        while (l <= r) {
            int mid = (l + ((r - l) >> 1));
            if (nums[mid] > k) r = mid - 1;
            else l = mid + 1;
        }

        return l;
    }

    public long countPairs(int[] xNums, int[] yNums, int n) {
        // code here
        Arrays.sort(xNums);
        Arrays.sort(yNums);

        long ans = 0;
        int noneOnes = 0;
        int numberOfThrees = 0;

        for (int x : xNums) {
            if (x == 1) continue;
            if (x == 2) {
                ans += (n - upperBound(yNums, 4));
            }
            else {
                ans += (n - upperBound(yNums, x));
            }
            if (x == 3) ++numberOfThrees;
            ++noneOnes;
        }

        for (int y : yNums) {
            if (y == 1) ans += noneOnes;
            if (y == 2) ans += numberOfThrees;
        }

        return ans;
    }
}
