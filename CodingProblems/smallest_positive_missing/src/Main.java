import java.util.Scanner;

class Solution {
    public int missingNumber(final int[] arr) {
        // code here
        final int n = arr.length;

        for (int i = 0; i < n; ++i) {
            if (arr[i] <= 0 || arr[i] > n) {
                arr[i] = n + 1;
            }
        }

        for (int i = 0; i < n; ++i) {
            final int val = Math.abs(arr[i]);
            if (val > 0 && val <= n && arr[val - 1] > 0) {
                arr[val - 1] *= -1;
            }
        }

        for (int i = 0; i < n; ++i) {
            if (arr[i] > 0) {
                return i + 1;
            }
        }

        return n + 1;
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

           System.out.println(new Solution().missingNumber(arr));
       }
       
       scanner.close();
   }
}
