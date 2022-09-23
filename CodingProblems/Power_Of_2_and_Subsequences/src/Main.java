//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            ArrayList<Long> A = new ArrayList<>();
            String[] in = read.readLine().trim().split(" ");
            for (var i : in) {
                Long x = Long.parseLong(i);
                A.add(x);
            }

            Solution ob = new Solution();
            System.out.println(ob.numberOfSubsequences(A));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    private boolean isPowerOf2(long num) {
       while (num % 2 == 0) {
           num /= 2;
       }

       return num == 1;
    }

    public Long numberOfSubsequences(ArrayList<Long> nums) {
        // code here
        long ans = 0L;
        long r = 1L;
        final int MOD = (int) 1e9 + 7;

        for (long x: nums) {
            if (isPowerOf2(x)) ++ans;
        }

        for (int i = 1; i <= ans; ++i) {
            r = (r * 2) % MOD;
        }

        return (r - 1 + MOD) % MOD;
    }
}