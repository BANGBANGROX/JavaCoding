//{ Driver Code Starts
import java.io.*;
import java.util.HashSet;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
                new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();
            int K = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.countOfSubstrings(S,K));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    private boolean check(int[] count, int k) {
         int cnt = 0;

         for (int i = 0; i < 26; ++i) {
             if (count[i] > 0) ++cnt;
         }

         return cnt == (k - 1);
    }

    public int countOfSubstrings(String s, int k) {
        // code here
        int[] count = new int[26];
        int n = s.length();
        int l = 0;
        int r = k - 1;
        int ans = 0;

        for (int i = l; i <= r; ++i) {
            ++count[s.charAt(i) - 'a'];
        }

        while (r < n) {
            if (check(count, k)) ++ans;
            --count[s.charAt(l) - 'a'];
            ++l;
            ++r;
            if (r < n) {
                 ++count[s.charAt(r) - 'a'];
            }
        }

        return ans;
    }
}