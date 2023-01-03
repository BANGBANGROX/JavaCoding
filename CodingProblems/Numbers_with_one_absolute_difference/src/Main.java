//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            long n = Long.parseLong(read.readLine());

            Solution ob = new Solution();

            ArrayList<Long> answer = ob.absDifOne(n);

            for (long value : answer) {
                System.out.print(value + " ");
            }

            if (answer.size() == 0)
                System.out.print(-1);

            System.out.println();

        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    private final ArrayList<Long> ans = new ArrayList<>();

    private void generate(long num, int prevDigit, int len, long maxNum) {
        if (num > maxNum) return;

        if (len == 0) {
            ans.add(num);
            return;
        }

        if (prevDigit == -1) {
            for (int dig = 1; dig < 10; ++dig) {
                generate(dig, dig, len - 1, maxNum);
            }
            return;
        }

        if (prevDigit == 0) generate(num * 10 + 1, 1, len - 1, maxNum);
        else if (prevDigit == 9) generate(num * 10 + 8, 8, len - 1, maxNum);
        else {
            generate(num * 10 + prevDigit - 1, prevDigit - 1, len - 1, maxNum);
            generate(num * 10 + prevDigit + 1, prevDigit + 1, len - 1, maxNum);
        }
    }

    public ArrayList<Long> absDifOne(long n) {
        int maxLength = String.valueOf(n).length();

        for (int len = 2; len <= maxLength; ++len) {
            generate(0, -1, len, n);
        }

        return ans;
    }
}