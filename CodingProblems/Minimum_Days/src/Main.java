//{ Driver Code Starts

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int N;
            N = Integer.parseInt(br.readLine());


            String S;
            S = br.readLine();


            int[] P = IntArray.input(br, N);

            Solution obj = new Solution();
            int res = obj.getMinimumDays(N, S, P);

            out.println(res);

        }
        out.close();
    }
}

// } Driver Code Ends


class Solution {
    public int getMinimumDays(int n, String s, int[] p) {
        // code here
        int match = 0;
        char[] sArr = s.toCharArray();

        for (int i = 0; i < n - 1; ++i) {
            if (sArr[i] == sArr[i + 1]) {
                ++match;
            }
        }

        if (match == 0) return 0;

        for (int day = 0; day < n; ++day) {
            int i = p[day];
            if (i + 1 < n && sArr[i] == sArr[i + 1]) --match;
            if (i > 0 && sArr[i] == sArr[i - 1]) --match;
            if (match <= 0) return day + 1;
            sArr[i] = '?';
        }

        return -1;
    }
}