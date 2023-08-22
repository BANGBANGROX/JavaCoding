//{ Driver Code Starts

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


class IntMatrix {
    public static int[][] input(BufferedReader br, int n) throws IOException {
        int[][] mat = new int[n][];

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[s.length];
            for (int j = 0; j < s.length; j++)
                mat[i][j] = Integer.parseInt(s[j]);
        }

        return mat;
    }

}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int N;
            N = Integer.parseInt(br.readLine());


            int[][] matrix = IntMatrix.input(br, N);

            Solution obj = new Solution();
            int res = obj.findMinOperation(N, matrix);

            System.out.println(res);

        }
    }
}

// } Driver Code Ends



class Solution {
    public int findMinOperation(int n, int[][] matrix) {
        // code here
        long maxRowSum = 0;
        long maxColSum = 0;
        long totalSum = 0;

        for (int i = 0; i < n; ++i) {
            int rowSum = 0;
            int colSum = 0;
            for (int j = 0; j < n; ++j) {
                rowSum += matrix[i][j];
                colSum += matrix[j][i];
                totalSum += matrix[i][j];
            }
            maxRowSum = Math.max(maxRowSum, rowSum);
            maxColSum = Math.max(maxColSum, colSum);
        }

        long maxSum = Math.max(maxRowSum, maxColSum);

        return (int) (maxSum * n - totalSum);
    }
}

