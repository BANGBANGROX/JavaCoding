import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public boolean validGroup(final int[] nums, final int k) {
        // code here
        final int n = nums.length;

        if (n % k != 0) {
            return false;
        }

        final int maxValue = Arrays.stream(nums).max().getAsInt();
        final int[] count = new int[maxValue + 1];
        int currentSize = 0;

        for (final int num : nums) {
            ++count[num];
        }

        for (int i = 0; i <= maxValue; ++i) {
            if (count[i] > 0) {
                if (currentSize == 0) {
                    ++currentSize;
                } else if (count[i] != count[i - 1]) {
                    return false;
                } else {
                    ++currentSize;
                }
            }
            if (currentSize == k) {
                currentSize = 0;
            }
        }

        return currentSize % k == 0;
    }
}

public class Main {
   public static void main(String[] args) {
       final Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           final int n = scanner.nextInt();
           final int[] nums = new int[n];
           for (int i = 0; i < n; ++i) {
               nums[i] = scanner.nextInt();
           }
           final int k = scanner.nextInt();

           System.out.println(new Solution().validGroup(nums, k));
       }
       
       scanner.close();
   }
}
