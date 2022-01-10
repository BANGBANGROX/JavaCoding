import java.util.Scanner;

class Solution {
    public int numDecodings(String s) {
       int n = s.length();
       int[] dp = new int[n];

       if (s.charAt(0) == '0') return 0;

       if (n == 1) return 1;

       dp[0] = 1;

       for (int i = 1; i < n; ++i) {
           char first = s.charAt(i - 1);
           char second = s.charAt(i);
           int val = (i >= 2 ? dp[i - 2] : 1);
           if (first == '0' && second == '0') dp[i] = 0;
           else if (first == '0') dp[i] = dp[i - 1];
           else if (second == '0') {
               if (first == '1' || first == '2') dp[i] = val;
           }
           else {
               if (Integer.parseInt(s.substring(i - 1, i + 1)) <= 26) dp[i] = dp[i - 1] + val;
               else dp[i] = dp[i - 1];
           }
       }

       return dp[n - 1];
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            String s = sc.next();

            Solution obj = new Solution();
            System.out.println(obj.numDecodings(s));
        }

        sc.close();
    }
}
