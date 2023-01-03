//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntMatrix
{
    public static int[][] input(BufferedReader br, int n, int m) throws IOException
    {
        int[][] mat = new int[n][];

        for(int i = 0; i < n; i++)
        {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[s.length];
            for(int j = 0; j < s.length; j++)
                mat[i][j] = Integer.parseInt(s[j]);
        }

        return mat;
    }

    public static void print(int[][] m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }

    public static void print(ArrayList<ArrayList<Integer>> m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n;
            n = Integer.parseInt(br.readLine());


            int[][] mat = IntMatrix.input(br, n, n);

            Solution obj = new Solution();
            int res = obj.findMaxValue(n, mat);

            System.out.println(res);

        }
    }
}

// } Driver Code Ends


class Solution {
    public int findMaxValue(int n, int[][] mat) {
        // code here
        int ans = Integer.MIN_VALUE;

        for (int i = 1; i < n; ++i) {
            mat[i][0] = Math.min(mat[i][0], mat[i - 1][0]);
            mat[0][i] = Math.min(mat[0][i], mat[0][i - 1]);
        }

        for (int i = 1; i < n; ++i) {
            for (int j = 1; j < n; ++j) {
                int x = mat[i][j];
                mat[i][j] = Math.min(mat[i][j], Math.min(mat[i - 1][j], mat[i][j - 1]));
                ans = Math.max(ans, x - mat[i - 1][j - 1]);
            }
        }

        return ans;
    }
}

