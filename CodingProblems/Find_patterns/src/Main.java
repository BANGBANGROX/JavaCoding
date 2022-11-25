//{ Driver Code Starts

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();
            String W = read.readLine();

            Solution ob = new Solution();
            System.out.println(ob.numberOfSubsequences(S, W));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    public int numberOfSubsequences(String text, String pattern) {
        // code here
        int ans = 0;
        int m = text.length();
        int n = pattern.length();
        boolean[] visited = new boolean[m];

        for (int i = 0; i < m; ++i) {
            if (text.charAt(i) == pattern.charAt(0) && !visited[i]) {
                int idx = 1;
                for (int j = i + 1; j < m; ++j) {
                    if (!visited[j] && text.charAt(j) == pattern.charAt(idx)) {
                        ++idx;
                        visited[j] = true;
                    }
                    if (idx == n) {
                        ++ans;
                        break;
                    }
                }
            }
        }

        return ans;
    }
}