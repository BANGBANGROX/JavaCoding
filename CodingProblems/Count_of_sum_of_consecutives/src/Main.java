//{ Driver Code Starts
//Initial Template for Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read =
                new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.getCount(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    public int getCount(int n) {
        // code here
        if (n == 1) return 0;

        int ans = 0;

        for (int i = 1; i * (i - 1) / 2 < n; ++i) {
            int val = n - (i * (i - 1) / 2);
            if (val % i == 0) ++ans;
        }

        return ans - 1;
    }
}