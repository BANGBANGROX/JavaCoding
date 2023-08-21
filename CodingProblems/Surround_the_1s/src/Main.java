//{ Driver Code Starts
//Initial Template for Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] matrix = new int[n][m];
            for (int i = 0; i < n; i++) {
                String[] S = br.readLine().trim().split(" ");
                for (int j = 0; j < m; j++)
                    matrix[i][j] = Integer.parseInt(S[j]);
            }
            Solution ob = new Solution();
            int ans = ob.Count(matrix);
            out.println(ans);
        }
        out.close();
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    public int Count(int[][] matrix) {
        // code here
        int[][] directions = {{-1, -1}, {-1, 0}, {-1, 1}, {1, 1},
                {1, -1}, {1, 0}, {0, -1}, {0, 1}};
        int m = matrix.length;
        int n = matrix[0].length;
        int answer = 0;

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                int cnt = 0;
                for (int[] direction : directions) {
                    int newX = i + direction[0];
                    int newY = j + direction[1];
                    if (newX >= 0 && newX < m && newY >= 0 && newY < n &&
                            matrix[newX][newY] == 0) {
                        ++cnt;
                    }
                }
                if (cnt > 0 && (cnt & 1) == 0) {
                    ++answer;
                }
            }
        }

        return answer;
    }
}