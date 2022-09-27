//{ Driver Code Starts

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            long N;
            N = Long.parseLong(br.readLine().trim());

            Solution obj = new Solution();
            int res = obj.swapBitGame(N);

            System.out.println(res);

        }
    }
}

// } Driver Code Ends



class Solution {
    public int swapBitGame(long n) {
        // code here
        long xo = 0;
        long o = 0;

        while (n > 0) {
            if ((n & 1) > 0 && o > 0) {
                xo ^= o;
            }
            else if ((n & 1) == 0) ++o;
            n /= 2;
        }

        return xo > 0 ? 1 : 2;
    }
}

