// { Driver Code Starts
//Initial Template for Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter ot = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            long n = Long.parseLong(s[0]);

            ot.println(new Solution().count101(n));
        }
        ot.close();
    }
}


// } Driver Code Ends
//User function Template for Java

class Solution {
    private final StringBuilder binRep = new StringBuilder();
    private int ans = 0;

    private void count101(int idx, int len, String current) {
        if (len == 0) {
            if (current.equals("101")) ++ans;
            return;
        }

        if (idx == binRep.length()) return;

        count101(idx + 1, len - 1, current + binRep.charAt(idx));
        count101(idx + 1, len, current);
    }

    public int count101(long n) {
        // Code Here
        while (n > 0) {
            int dig = (int) (n % 2);
            binRep.append(dig);
            n >>= 1;
        }

        count101(0, 3, "");

        return ans;
    }
}

// { Driver Code Starts.
// } Driver Code Ends