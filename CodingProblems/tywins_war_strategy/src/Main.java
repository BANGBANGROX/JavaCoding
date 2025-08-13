import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Solution {
    public int minSoldiers(final int[] arr, final int k) {
        // code here
        final int n = arr.length;
        final List<Integer> needed = new ArrayList<>();
        int requiredCount = (n + 1) / 2;
        int answer = 0;

        for (final int num : arr) {
            if (num % k == 0) {
                --requiredCount;
            } else {
                final int nextMultiple = k * (num / k  + 1);
                needed.add(nextMultiple - num);
            }
        }

        if (requiredCount <= 0) {
            return 0;
        }

        Collections.sort(needed);

        for (int i = 0; i < requiredCount; ++i) {
            answer += needed.get(i);
        }

        return answer;
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
           final int k = scanner.nextInt();

           System.out.println(new Solution().minSoldiers(arr, k));
       }
       
       scanner.close();
   }
}
