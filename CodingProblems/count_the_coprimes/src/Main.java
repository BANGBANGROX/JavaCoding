import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public int cntCoprime(final int[] arr) {
        // code here
        final int maxValue = Arrays.stream(arr).max().getAsInt();
        final int[] count = new int[maxValue + 1];
        final int[] multiples = new int[maxValue + 1];
        final int[] dp = new int[maxValue + 1];

        for (final int num : arr) {
            ++count[num];
        }

        for (int num = 1; num <= maxValue; ++num) {
            for (int i = num; i <= maxValue; i += num) {
                multiples[num] += count[i];
            }
        }

        for (int i = maxValue; i > 0; --i) {
            final int cnt = multiples[i];
            dp[i] = cnt * (cnt - 1) / 2;
            for (int j = 2 * i; j <= maxValue; j += i) {
                dp[i] -= dp[j];
            }
        }

        return dp[1];
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

           System.out.println(new Solution().cntCoprime(arr));
       }
       
       scanner.close();
   }
}
