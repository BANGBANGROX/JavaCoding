//{ Driver Code Starts
//Initial Template for Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine().trim());
            Solution obj = new Solution();
            long ans = obj.NoOfChicks(N);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    public long NoOfChicks(int n) {
        // Code here
        long[] totalChickens = new long[n + 1];
        long[] newChickens = new long[n + 1];

        newChickens[1] = totalChickens[1] = 1;

        for (int i = 2; i <= n; ++i) {
            if (i < 7) {
                newChickens[i] = totalChickens[i - 1] * 2;
                totalChickens[i] = totalChickens[i - 1] * 3;
            }
            else {
                final long l = totalChickens[i - 1] - newChickens[i - 6];
                totalChickens[i] = l * 3;
                newChickens[i] = l * 2;
            }
        }

        return totalChickens[n];
    }
}