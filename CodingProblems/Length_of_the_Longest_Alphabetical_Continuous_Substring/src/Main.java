import javax.swing.text.Style;
import java.util.Scanner;

class Solution {
    public int longestContinuousSubstring(String s) {
         int currentLength = 1;
         int maxLength = 1;
         int n = s.length();

         for (int i = 1; i < n; ++i) {
             if (s.charAt(i) == s.charAt(i - 1) + 1) {
                 ++currentLength;
             }
             else {
                 maxLength = Math.max(maxLength, currentLength);
                 currentLength = 1;
             }
         }

         return maxLength;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            String s = sc.next();

            Solution solution = new Solution();
            System.out.println(solution.longestContinuousSubstring(s));
        }

        sc.close();
    }
}
