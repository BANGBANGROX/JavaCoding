//{ Driver Code Starts
//Initial Template for Java

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            long n = sc.nextLong();
            System.out.println(new Solution().colName(n));
        }

    }
}



// } Driver Code Ends


//User function Template for Java

class Solution {
    public String colName(long n) {
        // your code here
        if (n == 0) return "";

        if (n <= 26) return "" + (char)('A' + n - 1);

        if (n % 26 == 0) return colName(n / 26 - 1) + 'Z';

        return colName(n / 26) + (char)('A' + n % 26 - 1);
    }
}