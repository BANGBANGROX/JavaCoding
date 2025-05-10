import java.util.Scanner;

class Solution {
    public long minSum(final int[] nums1, final int[] nums2) {
        long firstMinSum = 0;
        long secondMinSum = 0;
        int firstZeroesCnt = 0;
        int secondZeroesCnt = 0;

        for (final int num : nums1) {
            if (num == 0) {
                ++firstMinSum;
                ++firstZeroesCnt;
            } else {
                firstMinSum += num;
            }
        }

        for (final int num : nums2) {
            if (num == 0) {
                ++secondMinSum;
                ++secondZeroesCnt;
            } else {
                secondMinSum += num;
            }
        }

        if (firstMinSum == secondMinSum) return firstMinSum;

        if (firstMinSum > secondMinSum) {
            return secondZeroesCnt > 0 ? firstMinSum : -1;
        }

        return firstZeroesCnt > 0 ? secondMinSum : -1;
    }
}

public class Main {
   public static void main(String[] args) {
       final Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           final int m = scanner.nextInt();
           final int[] nums1 = new int[m];
           for (int i = 0; i < m; ++i) {
               nums1[i] = scanner.nextInt();
           }
           final int n = scanner.nextInt();
           final int[] nums2 = new int[n];
           for (int i = 0; i < m; ++i) {
               nums2[i] = scanner.nextInt();
           }

           System.out.println(new Solution().minSum(nums1, nums2));
       }
       
       scanner.close();
   }
}
