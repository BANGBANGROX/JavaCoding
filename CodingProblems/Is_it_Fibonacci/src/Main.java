//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

public class Main
{
    static FastIO f;

    public static void main(String[] args) throws IOException
    {
        f = new FastIO();

        int t = f.nextInt();

        while(t-->0)
        {
            int N = f.nextInt(), K = f.nextInt();
            ArrayList<Long> GeekNum = new ArrayList<>();

            for(int i = 0; i < K; i++)
                GeekNum.add(f.nextLong());

            f.out(Solution.solve(N, K, GeekNum) + "\n");
        }

        f.flush();
    }
}

class FastIO
{
    BufferedReader br;
    PrintWriter bw, be;
    StringTokenizer st;

    public FastIO()
    {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new PrintWriter(System.out);
        be = new PrintWriter(System.err);
        st = new StringTokenizer("");
    }

    private void read() throws IOException
    {
        st = new StringTokenizer(br.readLine());
    }

    public String next() throws IOException
    {
        while(!st.hasMoreTokens())
            read();
        return st.nextToken();
    }

    public int nextInt() throws IOException
    {
        return Integer.parseInt(next());
    }

    public long nextLong() throws IOException
    {
        return Long.parseLong(next());
    }

    public void out(String s) {
        bw.print(s);
    }

    public void flush() {
        bw.flush();
        be.flush();
    }

}
// } Driver Code Ends


//User function Template for Java

class Solution {
    public static long solve(int n, int k, ArrayList<Long> geekNum) {
        //code here
        if (k >= n) return geekNum.get(n - 1);

        long[] dp = new long[n];
        long[] prefix = new long[n];

        for (int i = 0; i < k; ++i) {
            dp[i] = geekNum.get(i);
            if (i == 0) {
                prefix[0] = dp[0];
            }
            else {
                prefix[i] = prefix[i - 1] + dp[i];
            }
        }

        for (int i = k; i < n; ++i) {
            dp[i] = prefix[i - 1] - (i - k > 0 ? prefix[i - k - 1] : 0);
            prefix[i] = prefix[i - 1] + dp[i];
        }

        return dp[n - 1];
    }
}