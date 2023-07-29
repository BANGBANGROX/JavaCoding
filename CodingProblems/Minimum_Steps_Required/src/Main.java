//{ Driver Code Starts
//Initial Template for Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        while (test-- > 0) {
            String str = br.readLine();
            Solution obj = new Solution();
            System.out.println(obj.minSteps(str));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    public int minSteps(String s) {
        //Write your code here
        int n = s.length();
        int aSize = 0;
        int bSize = 0;

        for (int i = 0; i < n; ++i) {
            if (s.charAt(i) == 'a') {
                ++aSize;
                while (i < n && s.charAt(i) == 'a') ++i;
                --i;
            }
            else if (s.charAt(i) == 'b') {
                ++bSize;
                while (i < n && s.charAt(i) == 'b') ++i;
                --i;
            }
        }

        return Math.min(aSize, bSize) + 1;
    }
}