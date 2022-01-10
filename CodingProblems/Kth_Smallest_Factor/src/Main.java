// { Driver Code Starts
//Initial Template for Java

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        try (BufferedReader read = new BufferedReader(new InputStreamReader(System.in))) {
            int t = Integer.parseInt(read.readLine());
            while (t-- > 0) {
                String[] S;
                S = read.readLine().split(" ");

                int N = Integer.parseInt(S[0]);
                int K = Integer.parseInt(S[1]);

                System.out.println(Solution.kThSmallestFactor(N, K));
            }
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
    static int kThSmallestFactor(int n , int k) {
        // code here
        int count = 0;

        for (int i = 1; i * i <= n; ++i) {
            if (n % i == 0) {
                ++count;
                if (n / i != i) ++count;
            }
        }

        int left = 0, right = count + 1;

        for (int i = 1; i * i <= n; ++i) {
            if (n % i == 0) {
                ++left;
                if (left == k) return i;
                if (n / i != i) {
                    --right;
                    if (right == k) return n / i;
                }
            }
        }

        return -1;
    }
};