import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution {
    public String findLargest(final int[] arr) {
        // code here
        final List<String> arrString = new ArrayList<>();
        final StringBuilder answer = new StringBuilder();

        for (final int num : arr) {
            arrString.add(String.valueOf(num));
        }

        arrString.sort(
                (a, b) -> {
                    final String first = a + b;
                    final String second = b + a;

                    return second.compareTo(first);
                }
        );

        for (final String s : arrString) {
            answer.append(s);
        }

        return answer.charAt(0) == '0' ? "0" : answer.toString();
    }
}

public class Main {
   public static void main(String[] args) {
       final Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           final int n = scanner.nextInt();
           final int[] arr = new int[n];
           for (int i = 0; i < n; ++i) {
               arr[i] = scanner.nextInt();
           }

           System.out.println(new Solution().findLargest(arr));
       }
       
       scanner.close();
   }
}
