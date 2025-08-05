import java.util.Scanner;

class Solution {
    public boolean isPalinSent(final String s) {
        // code here
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            boolean invalid = false;

            if (!isValid(s.charAt(left))) {
                invalid = true;
                ++left;
            }

            if (!isValid(s.charAt(right))) {
                invalid = true;
                --right;
            }

            if (invalid) {
                continue;
            }

            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }

            ++left;
            --right;
        }

        return true;
    }

    private boolean isValid(final char ch) {
        return Character.isLetterOrDigit(ch);
    }
}

public class Main {
   public static void main(String[] args) {
       final Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           System.out.println(new Solution().isPalinSent(scanner.nextLine()));
       }
       
       scanner.close();
   }
}
