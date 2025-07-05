import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public int findLucky(int[] arr) {
        final int maxValue = Arrays.stream(arr).max().getAsInt();
        final int[] count = new int[maxValue + 1];

        for (final int num : arr) {
            ++count[num];
        }

        for (int i = maxValue; i > 0; --i) {
            if (count[i] == i) {
                return i;
            }
        }

        return -1;
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

           System.out.println(new Solution().findLucky(arr));
       }
       
       scanner.close();
   }
}
