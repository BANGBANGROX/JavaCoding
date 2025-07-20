import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Solution {
    public int countValid(final int n, final int[] arr) {
        // code here
        final Set<Integer> allowedDigits = new HashSet<>();
        final Set<Integer> mustHaveDigits = new HashSet<>();
        int validFirstAllowedDigits = 0;
        final int totalNumbers = 9 * (int) Math.pow(10, n - 1);

        for (final int dig : arr) {
            mustHaveDigits.add(dig);
        }

        for (int i = 0; i < 10; ++i) {
            if (!mustHaveDigits.contains(i)) {
                allowedDigits.add(i);
                if (i > 0) {
                    ++validFirstAllowedDigits;
                }
            }
        }

        final int unimportantNumbers = validFirstAllowedDigits * (int) Math.pow(allowedDigits.size(), n - 1);

        return totalNumbers - unimportantNumbers;
    }
}

public class Main {
   public static void main(String[] args) {
       final Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           final int n = scanner.nextInt();
           final int digs = scanner.nextInt();
           final int[] arr = new int[digs];
           for (int i = 0; i < digs; ++i) {
               arr[i] = scanner.nextInt();
           }

           System.out.println(new Solution().countValid(n, arr));
       }
       
       scanner.close();
   }
}
