import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public int partitionArray(final int[] nums, final int k) {
        final int n = nums.length;
        int answer = 1;

        Arrays.sort(nums);

        int minElement = nums[0];

        for (int i = 1; i < n; ++i) {
            if (nums[i] - minElement > k) {
                ++answer;
                minElement = nums[i];
            }
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
           final int[] nums = new int[n];
           for (int i = 0; i < n; ++i) {
               nums[i] = scanner.nextInt();
           }
           final int k = scanner.nextInt();

           System.out.println(new Solution().partitionArray(nums, k));
       }
       
       scanner.close();
   }
}
