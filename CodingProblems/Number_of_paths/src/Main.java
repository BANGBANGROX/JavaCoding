//{ Driver Code Starts

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class GfG {

    public static void main (String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0){
            String[] inputLine = br.readLine().trim().split(" ");
            int M = Integer.parseInt(inputLine[0]);
            int N = Integer.parseInt(inputLine[1]);
            Solution ob = new Solution();
            System.out.println(ob.numberOfPaths(M, N));
        }
    }
}




// } Driver Code Ends


class Solution {
    private final int MOD = (int) 1e9 + 7;

    private long binaryExponentiation(long a, int b) {
        long result = 1;

        while (b > 0) {
            if ((b & 1) > 0) {
                result = (result * a) % MOD;
                --b;
            }
            a = (a * a) % MOD;
            b >>= 1;
        }

        return result;
    }

    private long getModularInverse(long num) {
        return binaryExponentiation(num, MOD - 2);
    }

    public long numberOfPaths(int m, int n) {
        // Code Here
        long answer = 1;

        for (int i = 1; i < m; ++i) {
            answer = (answer * (i + n - 1)) % MOD;
            answer = (answer * getModularInverse(i)) % MOD;
        }

        return answer;
    }

}