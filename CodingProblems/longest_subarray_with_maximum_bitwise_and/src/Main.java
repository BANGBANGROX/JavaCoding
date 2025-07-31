import java.util.Scanner;

class Solution {
    public int longestSubarray(final int[] nums) {
        int maxValue = Integer.MIN_VALUE;
        int answer = 0;
        int currentCount = 0;

        for (final int num : nums) {
            maxValue = Math.max(maxValue, num);
        }

        for (final int num : nums) {
            if (num == maxValue) {
                ++currentCount;
            } else if (currentCount > 0) {
                answer = Math.max(answer, currentCount);
                currentCount = 0;
            }
        }

        answer = Math.max(answer, currentCount);

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

           System.out.println(new Solution().longestSubarray(nums));
       }
       
       scanner.close();
   }
}
