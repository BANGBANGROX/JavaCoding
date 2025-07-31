import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Solution {
    public int subarrayBitwiseORs(final int[] arr) {
        Set<Integer> current = new HashSet<>();
        final Set<Integer> answer = new HashSet<>();

        current.add(0);

        for (final int num : arr) {
            final Set<Integer> next = new HashSet<>();
            next.add(num);

            for (final int orValue : current) {
                next.add(num | orValue);
            }

            current = next;
            answer.addAll(next);
        }

        return answer.size();
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

           System.out.println(new Solution().subarrayBitwiseORs(arr));
       }
       
       scanner.close();
   }
}
