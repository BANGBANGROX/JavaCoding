//{ Driver Code Starts
import java.util.*;

class Check_IsToepliz {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            int arr[][] = new int[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) arr[i][j] = sc.nextInt();
            }

            Solution g = new Solution();
            boolean b = g.isToeplitz(arr);

            if (b == true)
                System.out.println("true");
            else
                System.out.println("false");

            T--;
        }
    }
}
// } Driver Code Ends


class Solution {
    /*You are required to complete this method*/
    boolean isToeplitz(int[][] mat) {
        // Your code here
        int m = mat.length;
        int n = mat[0].length;

        for (int i = 0; i < n; ++i) {
            int val = mat[0][i];
            int j = 1;
            int startI = i + 1;
            while (startI < m && j < n) {
                if (mat[startI][j] != val) return false;
                ++startI;
                ++j;
            }
        }

        for (int i = 0; i < m; ++i) {
            int val = mat[i][0];
            int j = 1;
            int startI = i + 1;
            while (startI < m && j < n) {
                if (mat[startI][j] != val) return false;
                ++startI;
                ++j;
            }
        }

        return true;
    }
}