//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int[][] matrix = new int[n][n];
            for (int i = 0; i < n; i++) {
                String[] S = br.readLine().trim().split(" ");
                for (int j = 0; j < n; j++)
                    matrix[i][j] = Integer.parseInt(S[j]);
            }
            Solution ob = new Solution();
            long ans = ob.MissingNo(matrix);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    public long MissingNo(int[][] matrix) {
        // code here
        int m = matrix.length;
        int n = matrix[0].length;
        int x = -1;
        long ans = -1;
        long commonSum = -1;
        ArrayList<Long> rowSums = new ArrayList<>();

        for (int i = 0; i < m; ++i) {
            long currentSum = 0;
            for (int j = 0; j < n; ++j) {
                if (matrix[i][j] == 0) {
                    x = i;
                }
                currentSum += matrix[i][j];
            }
            rowSums.add(currentSum);
        }

        if (x == 0) {
            long temp = rowSums.get(0);
            rowSums.set(0, rowSums.get(1));
            rowSums.set(1, temp);
            x = 1;
        }

        for (int i = 1; i < rowSums.size(); ++i) {
            if (x == i) {
                if (rowSums.get(i) >= rowSums.get(i - 1)) return -1;
                ans = rowSums.get(i - 1) - rowSums.get(i);
                rowSums.set(i, rowSums.get(i - 1));
            }
            else if (!Objects.equals(rowSums.get(i), rowSums.get(i - 1))) return -1;
        }

        // COL CHECK
        long commonRowSum = rowSums.get(0);

        for (int i = 0; i < m; ++i) {
            long currentSum = 0;
            for (int j = 0; j < n; ++j) {
                if (matrix[j][i] == 0) currentSum += ans;
                else currentSum += matrix[j][i];
            }
            if (commonSum == -1) commonSum = currentSum;
            else if (commonSum != currentSum || commonRowSum != currentSum) return -1;
        }

        // DIAGONAL CHECK
        long diagonalSum1 = 0;
        long diagonalSum2 = 0;

        for (int i = 0; i < m; ++i) {
            if (matrix[i][i] == 0) {
                diagonalSum1 += ans;
            }
            else {
                diagonalSum1 += matrix[i][i];
            }
            if (matrix[i][n - i - 1] == 0) {
                diagonalSum2 += ans;
            }
            else {
                diagonalSum2 += matrix[i][n - i - 1];
            }
        }

        if (diagonalSum1 != diagonalSum2 || commonRowSum != diagonalSum1) return -1;

        return ans;
    }
}