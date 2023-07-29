//{ Driver Code Starts
//Initial Template for Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            int[] ans = ob.leastPrimeFactor(n);
            for (int i = 1; i <= n; i++) {
                out.print(ans[i] + " ");
            }
            out.println();
        }
        out.close();
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution {
    public int[] leastPrimeFactor(int n) {
        // code here
        int[] answer = new int[n + 1];

        for (int i = 0; i <= n; ++i) {
            answer[i] = i;
        }

        for (int i = 2; i <= n; ++i) {
            for (int j = 2 * i; j <= n; j += i) {
                if (answer[j] == j) {
                    answer[j] = i;
                }
            }
        }

        return answer;
    }
}