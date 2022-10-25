//{ Driver Code Starts
//Initial Template for Java


//Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String[] input_line = read.readLine().trim().split("\\s+");
            int N = Integer.parseInt(input_line[0]);
            int M = Integer.parseInt(input_line[1]);

            Solution ob = new Solution();
            int ans = ob.steppingNumbers(N, M);
            System.out.println(ans);
        }
    }
}



// } Driver Code Ends


//User function Template for Java

class Solution {
    private HashSet<Integer> visited;
    private int LOWER_LIMIT;
    private int UPPER_LIMIT;

    private void generate(int num, int digit, int len) {
        if (digit < 0 || digit > 9) return;

        if (len == 1) {
            num = num * 10 + digit;
            if (num >= LOWER_LIMIT && num <= UPPER_LIMIT) {
                visited.add(num);
            }
            return;
        }

        num = num * 10 + digit;

        generate(num, digit - 1, len - 1);
        generate(num, digit + 1, len - 1);
    }

    public int steppingNumbers(int n, int m) {
        // code here
        visited = new HashSet<>();
        LOWER_LIMIT = n;
        UPPER_LIMIT = m;
        int lowerLen = String.valueOf(n).length();
        int upperLen = String.valueOf(m).length();

        for (int i = lowerLen; i <= upperLen; ++i) {
            for (int digit = 0; digit < 10; ++digit) {
                generate(0, digit, i);
            }
        }

        return visited.size();
    }
}
