//{ Driver Code Starts
//Initial Template for Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String S = br.readLine().trim();
            Solution ob = new Solution();

            System.out.println(ob.countStrings(S));

        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    public long countStrings(String s) {
        // Code here
        long[] count = new long[26];
        long answer = 0;

        for (char ch : s.toCharArray()) {
            ++count[ch - 'a'];
        }

        for (int i = 0; i < 26; ++i) {
            for (int j = i + 1; j < 26; ++j) {
                answer += count[i] * count[j];
            }
        }

        return answer;
    }
}