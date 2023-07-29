// { Driver Code Starts
//Initial Template for Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter ot = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while(t-- > 0){
            int n = Integer.parseInt(br.readLine().trim());

            ot.println(new Solution().acceptTheChallenge(n));
        }
        ot.close();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    public long acceptTheChallenge(int k) {
        // Solve Here.
        int power = 2;
        int maxPower = (int) (Math.log10(k) / Math.log10(2)) + 1;

        while (power <= maxPower) {
            int value = (1 << power) - 1;
            if (k % value == 0) {
                return k / value;
            }
            ++power;
        }

        return -1;
    }
}
