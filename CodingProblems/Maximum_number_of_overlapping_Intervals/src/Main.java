// { Driver Code Starts
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

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){

            int n;
            n = Integer.parseInt(br.readLine());


            int[][] intervals = IntMatrix.input(br, n, 2);

            Solution obj = new Solution();
            int res = obj.overlap(n, intervals);

            System.out.println(res);

        }
    }
}
// } Driver Code Ends



class Solution {
    public int overlap(int n, int[][] intervals) {
        // code here
        int[] start = new int[n];
        int[] end = new int[n];
        int i = 1;
        int j = 0;
        int currentIntervals = 1;
        int ans = 1;

        Arrays.sort(start);
        Arrays.sort(end);

        while (i < n && j < n) {
            if (start[i] <= end[j]) {
                ++currentIntervals;
                ++i;
            }
            else {
                ans = Math.max(ans, currentIntervals);
                --currentIntervals;
                ++j;
            }
        }

        ans = Math.max(ans, currentIntervals);

        return ans;
    }
}

