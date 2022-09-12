//{ Driver Code Starts

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s1 = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s1[0]);
            int m = Integer.parseInt(s1[1]);
            char[][] matrix = new char[n][m];
            for (int i = 0; i < n; i++) {
                String S = br.readLine().trim();
                for (int j = 0; j < m; j++) {
                    matrix[i][j] = S.charAt(j);
                }
            }
            Solution obj = new Solution();
            int ans = obj.MinimumExchange(matrix);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution {
    private void create(char[][] matrix, char ch) {
       int m = matrix.length;
       int n = matrix[0].length;

       for (int i = 0; i < m; ++i) {
           char start = (i == 0 ? ch : matrix[i - 1][0] == 'A' ? 'B' : 'A');
           for (int j = 0; j < n; ++j) {
                matrix[i][j] = start;
                if (start == 'A') start = 'B';
                else start = 'A';
           }
       }
    }

    private int find(char[][] mat1, char[][] mat2) {
        int m = mat1.length;
        int n = mat1[0].length;
        int ans = 0;

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (mat1[i][j] != mat2[i][j]) ++ans;
            }
        }

        return ans;
    }

    public int MinimumExchange(char[][] matrix) {
        // Code here
        int m = matrix.length;
        int n = matrix[0].length;
        char[][] first = new char[m][n];
        char[][] second = new char[m][n];

        create(first, 'A');
        create(second, 'B');

        return Math.min(find(first, matrix), find(second, matrix));
    }
}