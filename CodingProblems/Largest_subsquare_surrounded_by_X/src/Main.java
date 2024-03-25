//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
                new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            char A[][] = new char[N][N];
            for (int i = 0; i < N; i++) {
                String S[] = read.readLine().trim().split(" ");
                for (int j = 0; j < N; j++) A[i][j] = S[j].charAt(0);
            }
            Solution ob = new Solution();
            System.out.println(ob.largestSubsquare(N, A));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int largestSubsquare(int n, char[][] matrix) {
        // code here
        int[][] rowWisePrefixSum = new int[n][n];
        int[][] colWisePrefixSum = new int[n][n];
        int answer = 0;

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (matrix[i][j] == 'X') {
                    rowWisePrefixSum[i][j] = 1;
                    colWisePrefixSum[j][i] = 1;
                    if (j > 0) {
                        rowWisePrefixSum[i][j] += rowWisePrefixSum[i][j - 1];
                    }
                    if (i > 0) {
                        colWisePrefixSum[i][j] += colWisePrefixSum[i - 1][j];
                    }
                    for (int k = Math.min(rowWisePrefixSum[i][j], colWisePrefixSum[i][j]); k >= answer; --k) {
                        if (colWisePrefixSum[i][j - k + 1] >= k && rowWisePrefixSum[i - k + 1][j] >= k) {
                            answer = Math.max(answer, k);
                            break;
                        }
                    }
                }
            }
        }

        return answer;
    }
}