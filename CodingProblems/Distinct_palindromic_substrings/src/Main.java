// { Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0){
            String str = read.readLine().trim();
            Solution obj = new Solution();
            int ans = obj.palindromeSubStrs(str);
            System.out.println(ans);
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution
{
    int palindromeSubStrs(String str) {
        // code here
        TreeMap<String, Boolean> mp = new TreeMap<>();
        int n = str.length();
        int[][] dp = new int[2][n + 1];

        str = '@' + str + '#';

        for (int j = 0; j < 2; ++j) {
            int i = 1;
            int rp = 0;
            while (i <= n) {
                while (str.charAt(i - rp - 1) == str.charAt(i + j + rp)) {
                    ++rp;
                }
                dp[j][i] = rp;
                int k = 1;
                while (dp[j][i - k] != rp - k && k < rp) {
                    dp[j][i + k] = Math.min(dp[j][i - k], rp - k);
                    ++k;
                }
                rp = Math.max(rp - k, 0);
                i += k;
            }
        }

        str = str.substring(1, n + 1);
        mp.put(str.substring(0, 1), true);

        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < 2; ++j) {
                for (int k = dp[j][i]; k > 0; --k) {
                    mp.put(str.substring(i - k - 1, i - k - 1 + 2 * k + j), true);
                }
            }
            mp.put(str.substring(i, i + 1), true);
        }

        return mp.size();
    }
} 