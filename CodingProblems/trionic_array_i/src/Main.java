import java.util.Scanner;

class Solution {
    public boolean isTrionic(final int[] nums) {
        final int n = nums.length;

        for (int p = 1; p < n - 2; ++p) {
            if (nums[p] <= nums[p - 1]) {
                break;
            }

            for (int q = p + 1; q < n - 1; ++q) {
                boolean found = true;

                if (nums[q] >= nums[q - 1]) {
                    break;
                }

                for (int r = q + 1; r < n; ++r) {
                    if (nums[r] <= nums[r - 1]) {
                        found = false;
                        break;
                    }
                }

                if (found) {
                    return true;
                }
            }
        }

        return false;
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

           System.out.println(new Solution().isTrionic(nums));
       }
       
       scanner.close();
   }
}
