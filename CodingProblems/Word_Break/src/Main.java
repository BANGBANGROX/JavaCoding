import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

class Solution {
    private boolean isPossible(String s, List<String> wordDict) {
        for (String value : wordDict) {
            if (value.matches(s)) return true;
        }

        return false;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
       int n = s.length();
       boolean[] dp = new boolean[n + 1];

       for (int i = 1; i <= n; ++i) {
           if (isPossible(s.substring(0, i), wordDict)) {
               dp[i] = true;
           }
           if (dp[i]) {
               if (i == n) return true;
               for (int j = i + 1; j <= n; ++j) {
                   if (!dp[j] && isPossible(s.substring(i, j), wordDict)) {
                       dp[j] = true;
                       if (j == n) return true;
                   }
               }
           }
       }

       return dp[n];
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            List<String> wordDict = new ArrayList<>();
            for (int i = 0; i < n; ++i) {
                String str;
                str = sc.next();
                wordDict.add(str);
            }
            System.out.println(wordDict);
            String s = sc.next();

            Solution obj = new Solution();
            System.out.println(obj.wordBreak(s, wordDict));
        }

        sc.close();
    }
}
