import java.util.Scanner;

class Solution {
    public int longestSubsequence(final String s, final int k) {
        final int n = s.length();
        int answer = 0;
        final int bitsNeeded = (int) (Math.log(k) / Math.log(2)) + 1;
        int currentSum = 0;

        for (int i = 0; i < n; ++i) {
            final char ch = s.charAt(n - i - 1);
            if (ch == '1') {
                if (i < bitsNeeded && currentSum + (1 << i) <= k) {
                    currentSum += (1 << i);
                    ++answer;
                }
            } else {
                ++answer;
            }
        }

        return answer;
    }
}

public class Main {
   public static void main(String[] args) {
       final Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           System.out.println(new Solution().longestSubsequence(scanner.next(), scanner.nextInt()));
       }
       
       scanner.close();
   }
}
