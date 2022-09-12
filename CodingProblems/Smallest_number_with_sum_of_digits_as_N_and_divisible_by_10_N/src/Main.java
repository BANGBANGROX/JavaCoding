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
            int n = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            String ans = ob.digitsNum(n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    public String digitsNum(int n) {
        // Code here
        StringBuilder num = new StringBuilder();
        int count = n;

        while (n > 0) {
            if (n < 9) {
                num.append(n);
                n = 0;
            }
            else {
                num.append(9);
                n -= 9;
            }
        }

        num.reverse();

        while (count > 0) {
            num.append(0);
            --count;
        }

        return num.toString();
    }
}