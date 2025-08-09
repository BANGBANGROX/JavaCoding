import java.util.Scanner;

class Solution {
    int getLongestPrefix(final String s) {
        // code here
        final int n = s.length();
        int len = n - 1;

        while (len > 0) {
            int start = len;
            int i = 0;

            while (start < n) {
                if (s.charAt(start) == s.charAt(i)) {
                    ++start;
                    ++i;
                } else {
                    break;
                }
            }

            if (start == n) {
                return len;
            }

            --len;
        }

        return -1;
    }
}

public class Main {
   public static void main(String[] args) {
       final Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           System.out.println(new Solution().getLongestPrefix(scanner.next()));
       }
       
       scanner.close();
   }
}
