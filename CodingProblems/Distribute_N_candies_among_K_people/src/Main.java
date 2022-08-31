//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
                new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            int N = Integer.parseInt(S[0]);
            int K = Integer.parseInt(S[1]);

            Solution ob = new Solution();
            Long[] res = ob.distributeCandies(N, K);

            for (int i = 0; i < K; i++)
                System.out.print(res[i] + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    public Long[] distributeCandies(int n, int k) {
        // code here
        Long[] ans = new Long[k];
        long value = 1;
        int i = 0;

        for (; i < k; ++i) {
            ans[i] = 0L;
        }

        i = 0;

        while (n > 0) {
            ans[i] += value;
            n -= value;
            ++value;
            i = (i + 1) % k;
            if (n < value) break;
        }

        if (n > 0) ans[i] += n;

        return ans;
    }
}