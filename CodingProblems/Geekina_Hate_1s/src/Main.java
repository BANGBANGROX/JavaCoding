//{ Driver Code Starts

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter ot = new PrintWriter(System.out);

        int t = Integer.parseInt(br.readLine().trim());
        Solution solution = new Solution();
        while (t-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int k = Integer.parseInt(s[1]);
            ot.println(solution.findNthNumber(n, k));
        }
        ot.close();
    }

}
// } Driver Code Ends


class Solution {
    private int n;
    private int k;

    private long getNCR(int n, int r) {
        // Computes nCr
        long result = 1;

        for (int i = 1; i <= r; ++i) {
            result *= (n - r + i);
            result /= i;
        }

        return result;
    }

    private long countNumsWithSetBits(long num, int bits) {
        // This function counts numbers <= num with at-most bits set bits

        if (bits == 0) {
            return 1;
        }

        if (num == 0) {
            return 0;
        }

        int lastBit = (int) (Math.log(num) / Math.log(2));

        if (lastBit < bits - 1) {
            return 0;
        }

        return getNCR(lastBit, bits) +
                countNumsWithSetBits(num ^ (1L << lastBit), bits - 1);
    }

    private boolean check(long num) {
        // Checks if there are <= n nums between 0 and num having at-most k set bits or not

        long result = 0;

        for (int i = 0; i <= k; ++i) {
            result += countNumsWithSetBits(num, i);
            if (result >= n) return true;
        }

        return false;
    }

    public long findNthNumber(int n, int k) {
        // Code Here.
        this.n = n;
        this.k = k;
        long low = 0;
        long high = (long) 1e15;

        while (low < high) {
            long mid = (low + ((high - low) >> 1));
            if (check(mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}