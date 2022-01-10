// { Driver Code Starts
//Initial Template for Java

import  java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int r = Integer.parseInt(inputLine[0]);
            int c = Integer.parseInt(inputLine[1]);
            boolean[][] mat = new boolean[r][c];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    mat[i][j] = (Integer.parseInt(inputLine[i * c + j]) == 1);
                }
            }

            int ans = new Solution().maxArea(mat, r, c);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java


class Solution {
    int maxArea(boolean[][] mat, int r, int c) {
        // code here
        int [][]hist = new int[r + 1][c + 1];
        int maxArea = 0;

        // Compute hist
        for (int j = 0; j < c; ++j) {
            if (mat[0][j]) hist[0][j] = 1;
            else hist[0][j] = 0;
            for (int i = 1; i < r; ++i) {
                if (mat[i][j]) hist[i][j] = hist[i - 1][j] + 1;
                else hist[i][j] = 0;
            }
        }

        // Sort hist
        for (int i = 0; i < r; ++i) {
            int []count = new int[r + 1];
            for (int j = 0; j < c; ++j) {
                ++count[hist[i][j]];
            }
            int colNo = 0;
            for (int j = r; j >= 0; --j) {
                if (count[j] > 0) {
                    for (int k = 0; k < count[j]; ++k) {
                        hist[i][colNo] = j;
                        ++colNo;
                    }
                }
            }
        }

        // Compute maximum area
        for (int i = 0; i < r; ++i) {
            for (int j = 0; j < c; ++j) {
                maxArea = Math.max(maxArea, (j + 1) * hist[i][j]);
            }
        }

        return maxArea;
    }
}