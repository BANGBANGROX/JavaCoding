//{ Driver Code Starts
//Initial Template for Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();

            Solution ob = new Solution();
            System.out.println(ob.isSumString(S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    private String s;
    private int n;

    private boolean isSumStringHandler(int idx, int numsNeeded, long requiredNum, long lastNum) {
        if (idx == n) return numsNeeded == 0;

        long currentNum = 0;

        for (int i = idx; i < n; ++i) {
            currentNum = currentNum * 10 + (s.charAt(i) - '0');
            if (numsNeeded > 1 && (i + 1 < n && s.charAt(i + 1) != '0')) {
                if (isSumStringHandler(i + 1, numsNeeded - 1,
                        currentNum + lastNum, currentNum)) {
                    return true;

                }
            } else if (currentNum == requiredNum &&
                    isSumStringHandler(i + 1, 0,
                            currentNum + lastNum, currentNum)) {
                return true;
            }
        }

        return false;
    }

    public int isSumString(String s) {
        // code here
        this.s = s;
        n = s.length();

        if (n < 3) return 0;

        return isSumStringHandler(0, 3, 0, 0) ? 1 : 0;
    }
}