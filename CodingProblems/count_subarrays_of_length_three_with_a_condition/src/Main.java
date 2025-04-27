import java.util.Scanner;

class Solution {
    public int countSubarrays(final int[] nums) {
        final int n = nums.length;
        int answer = 0;
        int left = 0;
        int right = 2;

        while (right < n) {
            if (2 * (nums[left] + nums[right]) == nums[left + 1]) {
                ++answer;
            }
            ++left;
            ++right;
        }

        return answer;
    }
}

public class Main {
   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           final int n = scanner.nextInt();
           final int[] nums = new int[n];
           for (int i = 0; i < n; ++i) {
               nums[i] = scanner.nextInt();
           }

           System.out.println(new Solution().countSubarrays(nums));
       }
       
       scanner.close();
   }
}
