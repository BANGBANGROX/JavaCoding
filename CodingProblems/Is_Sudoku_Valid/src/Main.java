//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-->0){
            String s1[] = in.readLine().trim().split("\\s+");
            int mat[][] = new int[9][9];
            for(int i = 0;i < 81;i++)
                mat[i/9][i%9] = Integer.parseInt(s1[i]);

            Solution ob = new Solution();
            System.out.println(ob.isValid(mat));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    public int isValid(int mat[][]){
        // code here
        int m = mat.length;

        // Check Rows
        for (int i = 0; i < m; ++i) {
            HashSet<Integer> visited = new HashSet<>();
            boolean result = true;
            for (int j = 0; j < m; ++j) {
                if (mat[i][j] == 0) continue;
                if (visited.contains(mat[i][j])) return 0;
                visited.add(mat[i][j]);
            }
        }

        // Check Cols
        for (int i = 0; i < m; ++i) {
            HashSet<Integer> visited = new HashSet<>();
            for (int j = 0; j < m; ++j) {
                if (mat[j][i] == 0) continue;
                if (visited.contains(mat[j][i])) return 0;
                visited.add(mat[j][i]);
            }
        }

        // Check 3x3 squares
        int firstRow = 0;
        int lastRow = 2;
        while (lastRow < m) {
            int firstCol = 0;
            int lastCol = 2;
            while (lastCol < m) {
                HashSet<Integer> visited = new HashSet<>();
                for (int i = firstRow; i <= lastRow; ++i) {
                    for (int j = firstCol; j <= lastCol; ++j) {
                        if (mat[i][j] == 0) continue;
                        if (visited.contains(mat[i][j])) return 0;
                        visited.add(mat[i][j]);
                    }
                }
                firstCol += 3;
                lastCol += 3;
            }
            firstRow += 3;
            lastRow += 3;
        }

        return 1;
    }
}