import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

class Solution {
    public int[] findEvenNumbers(final int[] digits) {
        final Set<Integer> visited = new HashSet<>();
        final int n = digits.length;
        final List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < n; ++i) {
            if (digits[i] != 0) {
                final StringBuilder currentNumber = new StringBuilder();
                currentNumber.append(digits[i]);
                for (int j = 0; j < n; ++j) {
                    if (i != j) {
                        currentNumber.append(digits[j]);
                        for (int k = 0; k < n; ++k) {
                            if (i != k && j != k && digits[k] % 2 == 0) {
                                currentNumber.append(digits[k]);
                                final int num = Integer.parseInt(currentNumber.toString());
                                if (!visited.contains(num)) {
                                    visited.add(num);
                                    answer.add(num);
                                }
                                currentNumber.deleteCharAt(2);
                            }
                        }
                        currentNumber.deleteCharAt(1);
                    }
                }
            }
        }

        Collections.sort(answer);

        return answer.stream().mapToInt(a -> a).toArray();
    }
}

public class Main {
   public static void main(String[] args) {
       final Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           final int n = scanner.nextInt();
           final int[] digits = new int[n];
           for (int i = 0; i < n; ++i) {
               digits[i] = scanner.nextInt();
           }

           final int[] answer = new Solution().findEvenNumbers(digits);
           for (final int x : answer) {
               System.out.print(x + " ");
           }
           System.out.println();
       }
       
       scanner.close();
   }
}
