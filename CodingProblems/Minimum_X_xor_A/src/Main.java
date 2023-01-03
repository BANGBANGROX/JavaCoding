//{ Driver Code Starts
// Initial Template for Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t =
                Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {

            int a = Integer.parseInt(br.readLine().trim());
            int b = Integer.parseInt(br.readLine().trim());

            Solution ob = new Solution();
            out.println(ob.minVal(a, b));
        }
        out.flush();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    private int setBitsCount(int num) {
        int ans = 0;

        while (num > 0) {
            if ((num & 1) > 0) ++ans;
            num >>= 1;
        }

        return ans;
    }

    public int minVal(int a, int b) {
        // code here
        int[] bits = new int[32];
        int setBits = setBitsCount(b);
        int ans = 0;

        for (int i = 31; i >= 0 && setBits > 0; --i) {
            if ((a & (1 << i)) > 0) {
                bits[i] = 1;
                --setBits;
            }
        }

        if (setBits > 0) {
            for (int i = 0; i < 32 && setBits > 0; ++i) {
                if (bits[i] == 0) {
                    bits[i] = 1;
                    --setBits;
                }
            }
        }

        for (int i = 31; i >= 0; --i) {
            ans = (ans * 2 + bits[i]);
        }

        return ans;
    }
}