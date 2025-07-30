import java.util.Scanner;

class Solution {
    public int getLastMoment(final int n, final int[] left, final int[] right) {
        // code here
        int maxLeft = 0;
        int maxRight = 0;

        for (final int val : left) {
            maxLeft = Math.max(maxLeft, val);
        }

        for (final int val : right) {
            maxRight = Math.max(maxRight, n - val);
        }

        return Math.max(maxLeft, maxRight);
    }
}

public class Main {
   public static void main(String[] args) {
       final Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           final int n = scanner.nextInt();
           final int leftCnt = scanner.nextInt();
           final int[] left = new int[leftCnt];
           for (int i = 0; i < leftCnt; ++i) {
               left[i] = scanner.nextInt();
           }
           final int rightCnt = scanner.nextInt();
           final int[] right = new int[rightCnt];
           for (int i = 0; i < rightCnt; ++i) {
               right[i] = scanner.nextInt();
           }

           System.out.println(new Solution().getLastMoment(n, left, right));
       }
       
       scanner.close();
   }
}
