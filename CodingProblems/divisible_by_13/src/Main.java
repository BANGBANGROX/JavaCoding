import java.util.Scanner;

class Solution {
    public boolean divby13(final String s) {
        // code here
        int rem = 0;

        for (final char ch : s.toCharArray()) {
            rem = (rem * 10 + ch - '0') % 13;
        }

        return rem == 0;
    }
}

public class Main {
   public static void main(String[] args) {
       final Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           System.out.println(new Solution().divby13(scanner.next()));
       }
       
       scanner.close();
   }
}
