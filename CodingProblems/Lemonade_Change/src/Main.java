//{ Driver Code Starts
// Initial Template for Java

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            Solution obj = new Solution();
            boolean ans = obj.lemonadeChange(n, a);
            System.out.println(ans ? "True" : "False");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public boolean lemonadeChange(int n, int[] bills) {
        // code here
        int fiveCount = 0;
        int tenCount = 0;

        for (int i = 0; i < n; ++i) {
            if (bills[i] == 5) {
                ++fiveCount;
            }
            if (bills[i] == 10) {
                if (fiveCount > 0) --fiveCount;
                else return false;
                ++tenCount;
            }
            if (bills[i] == 20) {
                if (fiveCount > 0 && tenCount > 0) {
                    --fiveCount;
                    --tenCount;
                }
                else if (fiveCount >= 3) fiveCount -= 3;
                else return false;
            }
        }

        return true;
    }
}