//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.numberOfConsecutiveOnes(N));
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    public int numberOfConsecutiveOnes(int n) {
        // code here
        if (n == 2) return 1;

        long first = 0;
        long second = 1;
        long answer = 1;
        final int MOD = (int) 1e9 + 7;

        for (int i = 3; i <= n; ++i) {
            long third = (first + second) % MOD;
            first = second;
            second = third;
            answer = (answer * 2 + third) % MOD;
        }

        return (int) answer;
    }
}
