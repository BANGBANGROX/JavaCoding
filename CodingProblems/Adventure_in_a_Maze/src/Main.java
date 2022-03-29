// { Driver Code Starts
//Initial Template for Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int[][] matrix = new int[n][n];
            for(int i = 0; i < n; i++){
                String[] s = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++)
                    matrix[i][j] = Integer.parseInt(s[j]);
            }
            Solution obj = new Solution();
            int[] ans = obj.FindWays(matrix);
            for (int an : ans) {
                System.out.print(an + " ");
            }
            System.out.println();

        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int[] FindWays(int[][] matrix) {
        // Code here
        final int mod = (int)1e9 + 7;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] numWays = new int[m][n];
        int[][] maxScore = new int[m][n];

        maxScore[m - 1][n - 1] = matrix[m - 1][n - 1];
        numWays[m - 1][n - 1] = 1;

        // Initialise last row
        for (int i = n - 2; i >= 0; --i) {
            if (matrix[m - 1][i] == 2) break;
            numWays[m - 1][i] = 1;
            maxScore[m - 1][i] = matrix[m - 1][i] + maxScore[m - 1][i + 1];
        }

        // Initialise last col
        for (int i = m - 2; i >= 0; --i) {
            if (matrix[i][n - 1] == 1) break;
            numWays[i][n - 1] = 1;
            maxScore[i][n - 1] = matrix[i][n - 1] + maxScore[i + 1][n - 1];
        }

        for (int i = m - 2; i >= 0; --i) {
            for (int j = n - 2; j >= 0; --j) {
                if (matrix[i][j] == 3) {
                    int score = Math.max(maxScore[i + 1][j], maxScore[i][j + 1]);
                    numWays[i][j] = (numWays[i + 1][j] + numWays[i][j + 1]) % mod;
                    maxScore[i][j] = score == 0 ? 0 : score + 3;
                }
                if (matrix[i][j] == 2) {
                    int score = maxScore[i + 1][j];
                    numWays[i][j] = numWays[i + 1][j];
                    maxScore[i][j] = score == 0 ? 0 : score + 2;
                }
                if (matrix[i][j] == 1) {
                    int score = maxScore[i][j + 1];
                    numWays[i][j] = numWays[i][j + 1];
                    maxScore[i][j] = score == 0 ? 0 : score + 1;
                }
            }
        }

        return new int[]{numWays[0][0], maxScore[0][0]};
    }
}